/*-------------------------------------------------------------
	FILE		: RandomDoubleGenerator.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 8th Mar 2024

	RandomDouble Generator class can be used for generating
	 random values

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;

public class RandomDoubleGenerator implements Iterable<Double> {
    private final RandomGenerator m_randomGenerator;
    private final double m_origin;
    private final double m_bound;
    private final double m_count;
    private RandomDoubleGenerator(RandomGenerator randomGenerator, double origin, double bound, double count)
    {
        m_randomGenerator = randomGenerator;
        m_origin = origin;
        m_bound = bound;
        m_count = count;
    }
    public static RandomDoubleGenerator of(RandomGenerator randomGenerator, double origin, double bound, int count)
    {
        return new RandomDoubleGenerator(randomGenerator, origin, bound, count);
    }
    @Override
    public Iterator<Double> iterator()
    {
        return new RandomDoubleGeneratorIterator(this);
    }
    private static class RandomDoubleGeneratorIterator implements Iterator<Double> {
        final RandomDoubleGenerator doubleGenerator;
        double count;
        public RandomDoubleGeneratorIterator(RandomDoubleGenerator randomDoubleGenerator)
        {
            this.doubleGenerator = randomDoubleGenerator;
        }
        @Override
        public boolean hasNext()
        {
            return count < doubleGenerator.m_count;
        }

        @Override
        public Double next()
        {
            if (!hasNext())
                throw new NoSuchElementException("No such element !...");

            count++;
            return doubleGenerator.m_randomGenerator.nextDouble(doubleGenerator.m_origin, doubleGenerator.m_bound);
        }
    }

}
