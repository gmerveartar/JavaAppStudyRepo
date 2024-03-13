package org.csystem.generator.range;

import org.junit.Assert;
import org.junit.Test;

public class IntToLongRangeTest {

    @Test
    public void givenValues_whenBounds_thenIterate()
    {
        var a = 10;
        var b = 20;
        var index = 0L;

        for (long val : IntToLongRange.of(a, b)) {
            System.out.printf("%d ", val);
            Assert.assertEquals(a + index++, val);
        }

        System.out.println();
    }
    @Test
    public void givenValues_whenBoundsAndStep_thenIterate()
    {
        var a = 10;
        var b = 30;
        var index = 0L;
        var step = 2;

        for (long val : IntToLongRange.of(a, b, step)) {
            System.out.printf("%d ", val);
            Assert.assertEquals(a + index++ * step, val);
        }

        System.out.println();
    }
    @Test
    public void givenValues_whenBoundsAndOperator_thenIterate()
    {
        var a = 10;
        var b = 50;
        var index = 0L;
        var step = 3;

        for (long val : IntToLongRange.of(a, b, val -> val + step)) {
            System.out.printf("%d ", val);
            Assert.assertEquals(a + index++ * step, val);
        }

        System.out.println();
    }
    @Test
    public void givenValues_whenBoundsAndOperatorWithMultiply_thenIterate()
    {
        var a = 10;
        var b = 500_000;
        var step = 3;

        for (long val : IntToLongRange.of(a, b, val -> val * step))
            System.out.printf("%d ", val);

        System.out.println();
    }
    @Test
    public void givenValues_whenBounds_thenThrowsIllegalArgumentsException()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> IntToLongRange.of(5, 4)) ;
    }
    @Test
    public void givenValues_whenBoundsAndStep_thenThrowsIllegalArgumentsException()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> IntToLongRange.of(5, 4, 0)) ;
    }

}
