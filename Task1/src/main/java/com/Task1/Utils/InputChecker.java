package com.Task1.Utils;

import com.Task1.Enums.ProgramState;
import com.Task1.Interface.ICheckInput;
import lombok.NonNull;
import org.apache.commons.lang.ArrayUtils;

import java.util.regex.Pattern;

public class InputChecker implements ICheckInput {

    private String[] rawArgs;
    private ProgramState programState;
    private String calculatorInput;

    public InputChecker(@NonNull String[] args) {
        rawArgs = args;
        calculatorInput = "";
        programState = ProgramState.Help;
    }

    @Override
    public ProgramState check() {
        formatInput();

        boolean overall = Pattern.compile("\\d+?[\\+\\-\\*\\:]\\d+?").matcher(calculatorInput).find();

        long multiply = Pattern.compile("\\*").matcher(calculatorInput).results().count();
        long divide = Pattern.compile("\\:").matcher(calculatorInput).results().count();
        long add = Pattern.compile("\\+").matcher(calculatorInput).results().count();
        long subtract = Pattern.compile("\\-").matcher(calculatorInput).results().count();

        if(overall && operationLimit(multiply, divide, add, subtract)) {
            programState = ProgramState.Calculate;
        }

        return programState;
    }

    @Override
    public String getInput() {

        return calculatorInput;
    }

    private void formatInput() {
        if(ArrayUtils.isEmpty(rawArgs)) {
            calculatorInput = "";
        } else {
            calculatorInput = rawArgs[0].trim();
        }
    }

    private boolean operationLimit(long multiply, long divide, long add, long subtract) {

        if(multiply <= 1 && divide <=1 && add <= 1 && subtract <=1){
            return true;
        }

        return false;
    }

}
