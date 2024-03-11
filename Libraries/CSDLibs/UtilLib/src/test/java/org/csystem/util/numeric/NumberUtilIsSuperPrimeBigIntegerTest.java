package org.csystem.util.numeric;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

// @Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class NumberUtilIsSuperPrimeBigIntegerTest {
    static class DataInfo {
        BigInteger input;
        Boolean expected;

        public DataInfo(BigInteger input, Boolean expected) {
            this.input = input;
            this.expected = expected;
        }
    }

    DataInfo dataInfo;

    public NumberUtilIsSuperPrimeBigIntegerTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(BigInteger.valueOf(41), true),
                new DataInfo(BigInteger.valueOf(7), false),
                new DataInfo(BigInteger.valueOf(5), true)
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.isSuperPrime(dataInfo.input));
    }
}
