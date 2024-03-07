package org.csystem.recursion.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class UtilFactorialTest {
    static class DataInfo {
        int input;
        long expected;

        public DataInfo(int input, long expected) {
            this.input = input;
            this.expected = expected;
        }
    }
    DataInfo dataInfo;
    public UtilFactorialTest(DataInfo dataInfo)
    {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(-1, 1),
                new DataInfo(0, 1),
                new DataInfo(1, 1),
                new DataInfo(2, 2),
                new DataInfo(3, 6),
                new DataInfo(5, 120),
                new DataInfo(15, 1_307_674_368_000L)
        );
    }

    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, Util.factorial(dataInfo.input));
    }


}
