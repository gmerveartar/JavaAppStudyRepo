/*-------------------------------------------------------------
	FILE		: IntRange.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 7th Mar 2024

	IntRange class can be used for values in an interval

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntUnaryOperator;

public class IntRange implements Iterable<Integer> {
    private final int m_a;
    private final int m_b;
    private final IntUnaryOperator m_unaryOperator;
    private IntRange(int a, int b, IntUnaryOperator unaryOperator)
    {
        m_a = a;
        m_b = b;
        m_unaryOperator = unaryOperator;
    }

    public static IntRange of(int a, int b, int step)
    {
        if (a > b)
            throw new IllegalArgumentException(String.format("a cannot be greater than b: a = %d, b = %d", a, b));

        if (step <= 0)
            throw new IllegalArgumentException(String.format("step must be positive : step = %d", step));

        return new IntRange(a, b, val -> val + step);
    }
    public static IntRange of(int a, int b)
    {
       return of(a, b, 1);
    }
    public static IntRange of(int a, int b, IntUnaryOperator unaryOperator)
    {
        if (a > b)
            throw new IllegalArgumentException(String.format("a cannot be greater than b: a = %d, b = %d", a, b));

        return new IntRange(a, b, unaryOperator);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int value = m_a;
            @Override
            public boolean hasNext()
            {
                return value <= m_b ;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element!...");

                var result = value;
                value = m_unaryOperator.applyAsInt(value);

                return result;
            }
        };
    }
}
