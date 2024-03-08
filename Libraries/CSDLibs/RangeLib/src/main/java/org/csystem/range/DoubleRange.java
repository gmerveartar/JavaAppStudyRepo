/*-------------------------------------------------------------
	FILE		: DoubleRange.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 7th Mar 2024

	Double Range class can be used for values in an interval

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.DoubleUnaryOperator;

public class DoubleRange implements Iterable<Double> {
    private final double m_a;
    private final double m_b;
    private final DoubleUnaryOperator m_unaryOperator;
    private DoubleRange(double a, double b, DoubleUnaryOperator unaryOperator)
    {
        m_a = a;
        m_b = b;
        m_unaryOperator = unaryOperator;
    }
    public static DoubleRange of(double a, double b, double delta)
    {
        if (a > b)
            throw new IllegalArgumentException(String.format("a cannot be greater than b: a = %f, b = %f", a, b));

        if (delta <= 0)
            throw new IllegalArgumentException(String.format("delta must be positive : step = %.20f", delta));

        return of(a, b, val -> val + delta);
    }
    public static DoubleRange of(double a, double b, DoubleUnaryOperator unaryOperator)
    {
        if (a > b)
            throw new IllegalArgumentException("a must be greater than b !...");

        return new DoubleRange(a, b, unaryOperator);
    }
    @Override
    public Iterator<Double> iterator()
    {
        return new DoubleRangeIterator();
    }

    private class DoubleRangeIterator implements Iterator<Double> {
        double value = m_a;

        @Override
        public boolean hasNext()
        {
            return value <= m_b;
        }
        @Override
        public Double next()
        {
            if (!hasNext())
                throw new NoSuchElementException("No such element !...");

            var result = value;
            value = m_unaryOperator.applyAsDouble(value);
            return result;
        }
    }
}
