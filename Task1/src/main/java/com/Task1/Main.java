package com.Task1;

import com.Task1.Enums.ProgramState;
import com.Task1.Interface.ICalculator;
import com.Task1.Interface.ICheckInput;
import com.Task1.Logic.Calculator;
import com.Task1.Utils.InputChecker;

public class Main {

    //Calculator
    public static void main(String[] args) {
        System.out.println("Start...");

        ICheckInput input = new InputChecker(args);
        ProgramState programState = input.check();

        switch (programState) {
            case Calculate -> {
                ICalculator calculator = new Calculator(input.getInput());
                System.out.format("Calculating... %s%n", input.getInput());
                int result = calculator.calculate();
                System.out.format("Result: %d%n", result);
                System.out.println("Calculating END.");
            }

            case Help -> {
                System.out.println("Can calculate only one of each type in single request:");
                System.out.println("adding(+), subtraction(-), multiplication(*), division(:)");
                System.out.println("Example:");
                System.out.println("12+2-1*2:1");
                System.out.println("23*4:2");
                System.out.println("46:2");
            }
        }

        System.out.println("End.");
    }

}
