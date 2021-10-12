package com.Task1.Logic.CalcOperations;

import com.Task1.Interface.ICalOperation;
import com.Task1.Interface.ICalcResult;
import lombok.NonNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcOperationDivide implements ICalOperation {

    private String regex = "\\d+\\:\\d+";

    @Override
    public ICalcResult proceed(@NonNull ICalcResult calcResult) {

        Matcher match = Pattern.compile(regex).matcher(calcResult.getOperation());

        if (match.find()) {
            String matchResult = match.group();
            String[] toCalc = matchResult.split("\\:");

            if (Integer.parseInt(toCalc[1]) == 0) {
                throw new ArithmeticException();
            }

            int result = Integer.parseInt(toCalc[0]) / Integer.parseInt(toCalc[1]); //TODO: zero check
            calcResult.setOperation(calcResult.getOperation().replace(matchResult, String.valueOf(result)));
        }

        return calcResult;
    }
}
