/*-------------------------------------------------------------
	FILE		: RandomIntGenerator.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 12 th Mar 2024

	RandomIntGenerator class can be used for generating 
	 random values

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.generator.random;

import org.csystem.generator.NValueGenerator;

import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.random.RandomGenerator;

public class  RandomIntGenerator extends NValueGenerator<Integer> {
    public RandomIntGenerator(RandomGenerator randomGenerator, int origin, int bound, int count)
    {
        super.supplier = () -> randomGenerator.nextInt(origin, bound);
        super.noSuchElementExceptionMessage = "No such element!...";
        super.count = count;

    }
    public static RandomIntGenerator of(RandomGenerator randomGenerator, int origin, int bound, int count)
    {
        return new RandomIntGenerator(randomGenerator, origin, bound, count);
    }
    public OptionalInt findFirst(IntPredicate predicate)
    {
        for (var val : this)
            if (predicate.test(val))
                return OptionalInt.of(val);
        return OptionalInt.empty(); 

    }
}
