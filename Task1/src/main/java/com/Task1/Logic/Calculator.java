package com.Task1.Logic;

import com.Task1.Interface.ICalculator;

/* (*) (:) (+) (-) */

public class Calculator implements ICalculator {

    private String rawInput;

    public Calculator(String input) {
        rawInput = input;
    }

    @Override
    public int calculate() {
        return 0;
    }
}
