/*-------------------------------------------------------------
	FILE		: RandomIntGenerator.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 8th Mar 2024

	RandomIntGenerator class can be used for generating 
	 random values

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;

public class RandomIntGenerator implements Iterable<Integer> {
    private final RandomGenerator m_randomGenerator; 
    private final int m_origin;
    private final int m_bound;
    private final int m_count;
    public RandomIntGenerator(RandomGenerator randomGenerator, int origin, int bound, int count)
    {
        m_origin = origin;
        m_bound = bound;
        m_count = count;
        m_randomGenerator = randomGenerator;
    }
    public static RandomIntGenerator of(RandomGenerator randomGenerator, int origin, int bound, int count)
    {
        return new RandomIntGenerator(randomGenerator, origin, bound, count );
    }
    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int count = 0;
            @Override
            public boolean hasNext()
            {
                return count < m_count;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("Cannot generate a value!..");

                count++;
                return m_randomGenerator.nextInt(m_origin, m_bound);
            }
        };
    }
}
