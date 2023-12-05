package com.artardev.util.numeric;

import com.artardev.util.numeric.data.IntLongDataInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class NumberUtilFactorialTest {
    IntLongDataInfo dataInfo;

    public NumberUtilFactorialTest(IntLongDataInfo dataInfo)
    {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<IntLongDataInfo> createData()
    {
        return List.of(new IntLongDataInfo(2, 2),
                new IntLongDataInfo(3, 6),
                new IntLongDataInfo(5, 120),
                new IntLongDataInfo(15, 1_307_674_368_000L)
        );
    }

    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.factorial(dataInfo.input));
    }


}
