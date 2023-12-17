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

@Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class NumberUtilGetPrimeBigIntegerTest {

    BigIntegerDataInfo dataInfo;

    public NumberUtilGetPrimeBigIntegerTest(BigIntegerDataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    @Parameterized.Parameters
    public static Collection<BigIntegerDataInfo> createData()
    {
        return List.of(new BigIntegerDataInfo(BigInteger.TEN, BigInteger.valueOf(29)),
                new BigIntegerDataInfo(BigInteger.ONE, BigInteger.TWO)
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.getPrime(dataInfo.input));
    }
}
