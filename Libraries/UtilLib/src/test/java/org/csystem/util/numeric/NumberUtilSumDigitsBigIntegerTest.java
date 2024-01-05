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
public class NumberUtilSumDigitsBigIntegerTest {

    BigIntegerDataInfo dataInfo;

    public NumberUtilSumDigitsBigIntegerTest(BigIntegerDataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    @Parameterized.Parameters
    public static Collection<BigIntegerDataInfo> createData()
    {
        return List.of(new BigIntegerDataInfo(BigInteger.valueOf(10_020_045_651L), BigInteger.valueOf(24)),
                new BigIntegerDataInfo(BigInteger.valueOf(1000), BigInteger.ONE),
                new BigIntegerDataInfo(BigInteger.valueOf(321), BigInteger.valueOf(6))
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.sumDigits(dataInfo.input));
    }
}
