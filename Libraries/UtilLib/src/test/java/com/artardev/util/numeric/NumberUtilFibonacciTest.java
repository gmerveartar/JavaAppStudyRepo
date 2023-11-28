package com.artardev.util.numeric;

import org.junit.Assert;
import org.junit.Test;

public class NumberUtilFibonacciTest {

    @Test
    public void givenValue_WhenIndex_ThenReturnsNumber()
    {
        int input = 5;
        int expected = 3;

        Assert.assertEquals(expected, NumberUtil.fibonacciNumber(input));
    }
}
