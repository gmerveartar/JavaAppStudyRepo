package org.csystem.util.string;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

// @Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class StringUtilAreAnagramTest {
    static class DataInfo {
        String s1;
        String s2;
        boolean expected;
         DataInfo(String s1, String s2, boolean expected)
        {
            this.s1 = s1;
            this.s2 = s2;
            this.expected = expected;
        }
    }

    public StringUtilAreAnagramTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    public DataInfo dataInfo;
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo("para", "arap", true),
                new DataInfo("bart", "brat", true),
                new DataInfo("bratt", "baart", false),
                new DataInfo("aaaa", "aaaa", true),
                new DataInfo("", "", false),
                new DataInfo("    ", "     ", false)
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, StringUtil.areAnagram(dataInfo.s1, dataInfo.s2));
    }
}
