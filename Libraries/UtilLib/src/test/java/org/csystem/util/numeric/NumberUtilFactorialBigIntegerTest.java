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
public class NumberUtilFactorialBigIntegerTest {
    static class DataInfo {
        int input;
        BigInteger expected;

        public DataInfo(int input, BigInteger expected) {
            this.input = input;
            this.expected = expected;
        }
    }
    DataInfo dataInfo;

    public NumberUtilFactorialBigIntegerTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(2, BigInteger.TWO),
                new DataInfo(3, BigInteger.valueOf(6)),
                new DataInfo(5, BigInteger.valueOf(120)),
                new DataInfo(15, BigInteger.valueOf(1_307_674_368_000L))
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.factorialBigInteger(dataInfo.input));
    }
}
