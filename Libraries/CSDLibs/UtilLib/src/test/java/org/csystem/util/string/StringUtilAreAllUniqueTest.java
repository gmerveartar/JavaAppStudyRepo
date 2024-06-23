package org.csystem.util.string;

import org.csystem.util.numeric.NumberUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

// @Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class StringUtilAreAllUniqueTest {
    static class DataInfo {
        String input;
        boolean expected;

        public DataInfo(String input, boolean expected) {
            this.input = input;
            this.expected = expected;
        }
    }

    public StringUtilAreAllUniqueTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    public DataInfo dataInfo;
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo("ali", true),
                new DataInfo("aali", false),
                new DataInfo("", true) 

        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, StringUtil.areAllUnique(dataInfo.input));
    }
}
