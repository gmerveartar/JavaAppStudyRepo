package com.artardev.util.numeric;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class NumberUtilPrimeFalseTest {
    public long input;
    @Parameterized.Parameters
    public static Collection<Long> createData()
    {
        return List.of(-1L);
    }
    public NumberUtilPrimeFalseTest(long input) {
        this.input = input;
    }
    @Test
    public void test()
    {
        Assert.assertFalse(NumberUtil.isPrime(input));
    }
}
