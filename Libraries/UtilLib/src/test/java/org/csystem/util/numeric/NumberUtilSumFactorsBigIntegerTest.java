package org.csystem.util.numeric;


import org.csystem.util.numeric.data.BigIntegerDataInfo;
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
public class NumberUtilSumFactorsBigIntegerTest {

    BigIntegerDataInfo dataInfo;

    public NumberUtilSumFactorsBigIntegerTest(BigIntegerDataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    @Parameterized.Parameters
    public static Collection<BigIntegerDataInfo> createData()
    {
        return List.of(new BigIntegerDataInfo(BigInteger.valueOf(15), BigInteger.valueOf(9)),
                new BigIntegerDataInfo(BigInteger.valueOf(2), BigInteger.valueOf(1)),
                new BigIntegerDataInfo(BigInteger.valueOf(30), BigInteger.valueOf(42))
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.sumFactors(dataInfo.input));
    }
}
