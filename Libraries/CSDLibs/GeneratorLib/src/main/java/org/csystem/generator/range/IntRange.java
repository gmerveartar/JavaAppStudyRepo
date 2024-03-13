/*-------------------------------------------------------------
	FILE		: IntRange.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 8 th Mar 2024

	IntRange class can be used for values in an interval

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.generator.range;

import org.csystem.generator.Generator;
import java.util.function.UnaryOperator;

public class IntRange extends Generator<Integer> {
    private final int m_a;
    private final int m_b;
    private IntRange(int a, int b, UnaryOperator<Integer> unaryOperator)
    {
        m_a = a;
        m_b = b;
        this.unaryOperator = unaryOperator;
        predicate = val -> val < m_b;
        supplier = () -> m_a;
        noSuchElementExceptionMessage = "No such element!...";
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
    public static IntRange of(int a, int b, UnaryOperator<Integer> unaryOperator)
    {
        if (a > b)
            throw new IllegalArgumentException(String.format("a cannot be greater than b: a = %d, b = %d", a, b));

        return new IntRange(a, b, unaryOperator);
    }

}
