package com.artardev.util.numeric;

import com.artardev.util.numeric.data.IntIntDataInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class NumberUtilFibonacciTest {
    IntIntDataInfo dataInfo;
    public NumberUtilFibonacciTest(IntIntDataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<IntIntDataInfo> createData()
    {
        return List.of( new IntIntDataInfo(1, 0),
                        new IntIntDataInfo(2, 1),
                        new IntIntDataInfo(3, 1),
                        new IntIntDataInfo(4, 2),
                        new IntIntDataInfo(5, 3));
    }
    @Test
    public void givenValue_WhenIndex_ThenReturnsNumber()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.fibonacciNumber(dataInfo.input));
    }
}