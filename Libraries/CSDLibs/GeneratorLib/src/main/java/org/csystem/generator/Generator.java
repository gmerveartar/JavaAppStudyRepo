/*-------------------------------------------------------------
	FILE		: Generator.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 12th Mar 2024

	Generic iterable Generator class

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.generator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Generator<T> extends BaseGenerator<T>{
    protected UnaryOperator<T> unaryOperator;
    protected Predicate<T> predicate;
    protected Generator()
    {
    }

    public Optional<T> findFirst(Predicate<T> predicate)
    {
        for (var val : this)
            if (predicate.test(val))
                return Optional.of(val);
        return Optional.empty();
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<>() {
            T value = supplier .get();
            @Override
            public boolean hasNext()
            {
                return predicate.test(value);
            }
            @Override
            public T next()
            {
                if (!hasNext())
                    throw new NoSuchElementException(noSuchElementExceptionMessage);

                var result = value;

                value = unaryOperator.apply(value);

                return result;
            }
        };
    }

}
