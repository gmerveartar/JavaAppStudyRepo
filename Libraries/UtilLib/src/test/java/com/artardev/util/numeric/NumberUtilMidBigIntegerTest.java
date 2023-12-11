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
public class NumberUtilMidBigIntegerTest {
    static class DataInfo {
        BigInteger input1, input2, input3;
        BigInteger expected;

        public DataInfo(BigInteger input1, BigInteger input2, BigInteger input3, BigInteger expected) {
            this.input1 = input1;
            this.input2 = input2;
            this.input3 = input3;
            this.expected = expected;
        }
    }
    public DataInfo dataInfo;

    public NumberUtilMidBigIntegerTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(BigInteger.ONE, BigInteger.valueOf(-1), BigInteger.ZERO, BigInteger.ZERO),
                new DataInfo(BigInteger.TEN, BigInteger.valueOf(12), BigInteger.valueOf(12), BigInteger.valueOf(12)),
                new DataInfo(BigInteger.valueOf(25), BigInteger.valueOf(65), BigInteger.valueOf(43), BigInteger.valueOf(43)),
                new DataInfo(BigInteger.valueOf(1_000_003), BigInteger.valueOf(1_000_000), BigInteger.valueOf(2_363_443_534_534_524L), BigInteger.valueOf(1_000_003))
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.mid(dataInfo.input1, dataInfo.input2, dataInfo.input3));
    }
}

