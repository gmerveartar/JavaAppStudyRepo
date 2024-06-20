package com.merveartar.library.operation.component;

import com.merveartar.library.operation.IIntOperator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AddWithValueOperation implements IIntOperator {
    @Value("$(com.merveartar.value:0)")
    private int m_value;

    @Override
    public boolean isValid(char op)
    {
        return op == '+';
    }

    @Override
    public int applyAsInt(int a, int b)
    {
        return a + b + m_value;
    }
}
