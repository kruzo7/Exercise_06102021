package com.Task1.Logic;

import com.Task1.Interface.ICalOperation;
import com.Task1.Interface.ICalcResult;
import com.Task1.Interface.ICalculator;
import com.Task1.Logic.CalcOperations.*;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/* (*) (:) (+) (-) */

public class Calculator implements ICalculator {

    private String input;

    public Calculator(@NonNull String rawInput) {

        input = rawInput;
    }

    @Override
    public int calculate() {

        ICalcResult calcResult = new CalcResult(input);

        List<ICalOperation> operations = new ArrayList<ICalOperation>();
        operations.add(new CalcOperationMultiply());
        operations.add(new CalcOperationDivide());
        operations.add(new CalcOperationAdd());
        operations.add(new CalcOperationSubtract());

        for(var operation : operations) {
            operation.proceed(calcResult);
        }

        return calcResult.getFinalResult();
    }
}
