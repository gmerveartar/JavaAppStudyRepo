package com.merveartar.library.operation.component;

import com.merveartar.library.operation.IIntOperator;
import org.springframework.stereotype.Component;

@Component
public class DivideOperation implements IIntOperator {
    @Override
    public boolean isValid(char op)
    {
        return op == '/';
    }

    @Override
    public int applyAsInt(int a, int b)
    {
        return a / b;
    }
}
