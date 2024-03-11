package org.csystem.range;

import org.junit.Test;

public class DoubleRangeTest {
    @Test
    public void givenValues_whenBounds_thenIterate()
    {
        for (double val : DoubleRange.of(-2 * Math.PI, 2 * Math.PI, 0.1))
            System.out.println(Math.sin(val));

    }

}

