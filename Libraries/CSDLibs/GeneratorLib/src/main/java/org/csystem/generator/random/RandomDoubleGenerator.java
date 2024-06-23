/*-------------------------------------------------------------
	FILE		: RandomDoubleGenerator.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 8th Mar 2024

	RandomDouble Generator class can be used for generating
	 random values

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.generator.random;

import org.csystem.generator.NValueGenerator;
import java.util.random.RandomGenerator;

public class RandomDoubleGenerator extends NValueGenerator<Double> {
    private RandomDoubleGenerator(RandomGenerator randomGenerator, double origin, double bound, int count)
    {
        super.supplier = () -> randomGenerator.nextDouble(origin, bound);
        super.noSuchElementExceptionMessage = "No such element!...";
        super.count = count;
    }
    public static RandomDoubleGenerator of(RandomGenerator randomGenerator, double origin, double bound, int count)
    {
        return new RandomDoubleGenerator(randomGenerator, origin, bound, count);
    }

}
