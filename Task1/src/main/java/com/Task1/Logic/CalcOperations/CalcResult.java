package com.Task1.Logic.CalcOperations;

import com.Task1.Interface.ICalcResult;

public class CalcResult implements ICalcResult {

    private String input;

    public CalcResult(String rawInput) {
        input = rawInput;
    }

    @Override
    public int getFinalResult() {
        return Integer.valueOf(input);
    }

    @Override
    public String getOperation() {
        return input;
    }

    @Override
    public void setOperation(String replace) {
        input = replace;
    }
}
