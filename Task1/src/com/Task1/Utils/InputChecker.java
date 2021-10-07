package com.Task1.Utils;

import com.Task1.Enums.ProgramState;
import com.Task1.Interface.ICheckInput;

public class InputChecker implements ICheckInput {

    public InputChecker(String[] args) {
    }

    @Override
    public ProgramState check() {
        return null;
    }

    @Override
    public String[] getInput() {
        return new String[0];
    }
}
