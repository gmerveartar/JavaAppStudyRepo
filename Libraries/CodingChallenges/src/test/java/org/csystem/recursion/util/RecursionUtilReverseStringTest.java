package org.csystem.recursion.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class RecursionUtilReverseStringTest {
    static class DataInfo {
        String input;
        String expected;

        public DataInfo(String input, String expected) {
            this.input = input;
            this.expected = expected;
        }
    }
    DataInfo dataInfo;
    public RecursionUtilReverseStringTest(DataInfo dataInfo)
    {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo("ankara",  "arakna"),
                new DataInfo("alipapila",  "alipapila"),
                new DataInfo("ali",  "ila"),
                new DataInfo("",  "")
        );
    }

    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, RecursionUtil.reverse(dataInfo.input));
    }


}
