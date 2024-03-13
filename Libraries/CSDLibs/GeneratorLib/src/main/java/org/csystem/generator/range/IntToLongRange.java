/*-------------------------------------------------------------
	FILE		: IntToLongRange.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 7th Mar 2024

	IntRange class can be used for values in an interval

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.generator.range;

import org.csystem.generator.Generator;
import java.util.function.UnaryOperator;

public class IntToLongRange extends Generator<Long> {
    private final int m_a;
    private final int m_b;
    private IntToLongRange(int a, int b, UnaryOperator<Long> unaryOperator)
    {
        m_a = a;
        m_b = b;
        this.unaryOperator = unaryOperator;
        predicate = val -> val < m_b;
        supplier = () -> (long)m_a;
        noSuchElementExceptionMessage = "No such element!...";
    }

    public static IntToLongRange of(int a, int b, int step)
    {
        if (a > b)
            throw new IllegalArgumentException(String.format("a cannot be greater than b: a = %d, b = %d", a, b));

        if (step <= 0)
            throw new IllegalArgumentException(String.format("step must be positive : step = %d", step));

        return new IntToLongRange(a, b, val -> val + step);
    }
    public static IntToLongRange of(int a, int b)
    {
       return of(a, b, 1);
    }
    public static IntToLongRange of(int a, int b, UnaryOperator<Long> unaryOperator)
    {
        if (a > b)
            throw new IllegalArgumentException(String.format("a cannot be greater than b: a = %d, b = %d", a, b));

        return new IntToLongRange(a, b, unaryOperator);
    }
}
