package com.merveartar.library.operation.component;

import com.merveartar.library.operation.IIntOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AddOperation implements IIntOperator {
    @Override
    public boolean isValid(char op)
    {
        log.info("AddOperation::isValid via {}", op);
        return op == '+';
    }

    @Override
    public int applyAsInt(int a, int b)
    {
        log.info("AddOperation::isValid via {}, {}", a, b);
        return a + b;
    }
}
