package org.csystem.util.array;

import org.csystem.util.string.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

// @Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class ArrayUtilAreAllUniqueGenericTest {
    static class DataInfo {
        String [] input;
        boolean expected;

        public DataInfo(boolean expected, String... input)
         {
            this.input = input;
            this.expected = expected;
        }
    }

    public ArrayUtilAreAllUniqueGenericTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    public DataInfo dataInfo;
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(true, "ankara", "istanbul", "izmir"),
                new DataInfo( false, "ankara", "ankara", "izmir"),
                new DataInfo( false, "", ""),
                new DataInfo( true, "")
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, ArrayUtil .areAllUnique(dataInfo.input));
    }
}
