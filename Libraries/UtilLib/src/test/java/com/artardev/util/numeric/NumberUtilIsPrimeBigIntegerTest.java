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
public class NumberUtilIsPrimeBigIntegerTest {
    static class DataInfo {
        BigInteger input;
        Boolean expected;

        public DataInfo(BigInteger input, Boolean expected) {
            this.input = input;
            this.expected = expected;
        }
    }
    DataInfo data;
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(BigInteger.valueOf(710_584_055_392_819_667L), true),
                new DataInfo(BigInteger.valueOf(1_386_437_196_678_024_971L), true),
                new DataInfo(BigInteger.valueOf(19), true),
                new DataInfo(BigInteger.valueOf(71), true),
                new DataInfo(BigInteger.valueOf(-1), false),
                new DataInfo(BigInteger.ONE, false),
                new DataInfo(BigInteger. ZERO, false),
                new DataInfo(BigInteger.valueOf(8), false),
                new DataInfo(BigInteger.valueOf(1_000_002), false));
    }

    public NumberUtilIsPrimeBigIntegerTest(DataInfo data) {
        this.data = data;
    }

    @Test
    public void test()
    {
        Assert.assertEquals(data.expected, NumberUtil.isPrime(data.input));
    }
}
