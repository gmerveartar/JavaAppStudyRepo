package com.artardev.util.numeric;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class NumberUtilIsPrimeFalseTest {
    public long input;
    @Parameterized.Parameters
    public static Collection<Long> createData()
    {
        return List.of(-1L);
    }
    public NumberUtilIsPrimeFalseTest(long input) {
        this.input = input;
    }
    @Test
    public void test()
    {
        Assert.assertFalse(NumberUtil.isPrime(input));
    }
}
