package com.artardev.util.numeric;

import com.artardev.util.numeric.NumberUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class NumberUtilCountDigitsTest {
    static class DataInfo {
        long input;
        int expected;

        public DataInfo(long input, int expected) {
            this.input = input;
            this.expected = expected;
        }
    }
    DataInfo dataInfo;

    public NumberUtilCountDigitsTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(0, 1),
                new DataInfo(1, 1),
                new DataInfo(10, 2),
                new DataInfo(100, 3),
                new DataInfo(1000, 4));
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.countDigits(dataInfo.input));

    }
}
