package org.csystem.generator.range;

import org.junit.Test;

public class DoubleRangeTest {
    @Test
    public void givenValues_whenBounds_thenIterate()
    {
         DoubleRange.of(-2 * Math.PI, 2 * Math.PI, 0.1)
                 .forEach(a  -> System.out.println(Math.sin(a)));
    }

}

