/*-------------------------------------------------------------
	FILE		: DoubleRange.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 7th Mar 2024

	Double Range class can be used for values in an interval

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.generator.range;

import org.csystem.generator.Generator;
import java.util.function.UnaryOperator;

public class DoubleRange extends Generator<Double> {
    private final double m_a;
    private final double m_b;
    private DoubleRange(double a, double b, UnaryOperator<Double> unaryOperator)
    {
        m_a = a;
        m_b = b;
        this.unaryOperator = unaryOperator;
        predicate = val -> val < m_b;
        supplier = () -> m_a;
        noSuchElementExceptionMessage = "No such element!...";
    }
    public static DoubleRange of(double a, double b, double delta)
    {
        if (a > b)
            throw new IllegalArgumentException(String.format("a cannot be greater than b: a = %f, b = %f", a, b));

        if (delta <= 0)
            throw new IllegalArgumentException(String.format("delta must be positive : step = %.20f", delta));

        return of(a, b, val -> val + delta);
    }
    public static DoubleRange of(double a, double b, UnaryOperator<Double> unaryOperator)
    {
        if (a > b)
            throw new IllegalArgumentException("a must be greater than b !...");

        return new DoubleRange(a, b, unaryOperator);
    }
}
