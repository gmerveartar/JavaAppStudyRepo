package org.csystem.range;

import org.junit.Assert;
import org.junit.Test;

import java.io.Console;

public class IntRangeTest {

    @Test
    public void givenValues_whenBounds_thenIterate()
    {
        var a = 10;
        var b = 20;
        var index = 0;

        for (int val : IntRange.of(a, b)) {
            System.out.printf("%d ", val);
            Assert.assertEquals(a + index++, val);
        }

        System.out.println();
    }
    @Test
    public void givenValues_whenBoundsAndStep_thenIterate()
    {
        var a = 10;
        var b = 20;
        var index = 0;
        var step = 2;

        for (int val : IntRange.of(a, b, step)) {
            System.out.printf("%d ", val);
            Assert.assertEquals(a + index++ * step, val);
        }

        System.out.println();
    }

}
