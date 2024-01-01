package org.csystem.recursion.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class RecursionUtilGcdTest {
    static class DataInfo {
        int a;
        int b;
        int expected;

        public DataInfo(int a, int b, int expected) {
            this.a = a;
            this.b = b;
            this.expected = expected;
        }
    }
    DataInfo dataInfo;
    public RecursionUtilGcdTest(DataInfo dataInfo)
    {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(-1, 1, 1),
                new DataInfo(3, 5, 1),
                new DataInfo(10, 5, 5),
                new DataInfo(30, 20, 10)
        );
    }

    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, RecursionUtil.gcd(dataInfo.a, dataInfo.b));
    }


}
