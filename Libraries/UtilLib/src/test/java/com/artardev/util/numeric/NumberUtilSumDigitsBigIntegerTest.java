package com.artardev.util.numeric;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class NumberUtilSumDigitsBigIntegerTest {
    static class DataInfo {
        BigInteger input;
        BigInteger expected;

        public DataInfo(BigInteger input, BigInteger expected) {
            this.input = input;
            this.expected = expected;
        }
    }
    DataInfo dataInfo;
    public NumberUtilSumDigitsBigIntegerTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(BigInteger.valueOf(10_020_045_651L), BigInteger.valueOf(24)),
                new DataInfo(BigInteger.valueOf(1000), BigInteger.ONE),
                new DataInfo(BigInteger.valueOf(321), BigInteger.valueOf(6))
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.sumDigits(dataInfo.input));
    }
}
