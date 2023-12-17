package org.csystem.util.numeric;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class NumberUtilMidTest {
    static class DataInfo {
        int input1, input2, input3;
        int expected;

        public DataInfo(int input1, int input2, int input3, int expected) {
            this.input1 = input1;
            this.input2 = input2;
            this.input3 = input3;
            this.expected = expected;
        }
    }
    public DataInfo dataInfo;

    public NumberUtilMidTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(1, -1, 0, 0),
                new DataInfo(10, 12, 12, 12),
                new DataInfo(10, 10, 12, 10),
                new DataInfo(25, 65, 43, 43),
                new DataInfo(0, 0, 0, 0),
                new DataInfo(10, 10, 10, 10));
    }

    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.mid(dataInfo.input1, dataInfo.input2, dataInfo.input3));
    }
}

