package org.csystem.util.array;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

// @Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class ArrayUtilAreAllUniqueIntTest {
    static class DataInfo {
        int [] a;
        boolean expected;

        public DataInfo(boolean expected, int... a)
         {
            this.a = a;
            this.expected = expected;
        }
    }

    public ArrayUtilAreAllUniqueIntTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    public DataInfo dataInfo;
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(true, 1, 2, 3, 4),
                new DataInfo( false, 1, 2, 3, 3),
                new DataInfo( true, 1)
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, ArrayUtil .areAllUnique(dataInfo.a));
    }
}
