package com.artardev.util.numeric;


import com.artardev.util.numeric.data.IntIntDataInfo;
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
public class NumberUtilReverseBigIntegerTest {
    static class DataInfo {
        BigInteger input;
        BigInteger expected;

        public DataInfo(BigInteger input, BigInteger expected) {
            this.input = input;
            this.expected = expected;
        }
    }
    DataInfo dataInfo;
    public NumberUtilReverseBigIntegerTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(BigInteger.valueOf(10_020_045_651L), BigInteger.valueOf(15_654_002_001L)),
                new DataInfo(BigInteger.valueOf(1000), BigInteger.ONE),
                new DataInfo(BigInteger.valueOf(321), BigInteger.valueOf(123))
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.reverse(dataInfo.input));
    }
}
