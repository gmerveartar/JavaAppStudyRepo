package org.csystem.util.numeric;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

// @Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class NumberUtilIsPowerOfTwoTest {
    static class DataInfo {
        long input;
        boolean expected;
        public DataInfo(long input, boolean expected) {
            this.input = input;
            this.expected = expected;
        }
    }
    DataInfo dataInfo;

    public NumberUtilIsPowerOfTwoTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(1, true),
                new DataInfo(0, false),
                new DataInfo(8, true),
                new DataInfo(48, false),
                new DataInfo (-32, false),
                new DataInfo(32, true));
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.isPowerOfTwo(dataInfo.input));

    }
}
