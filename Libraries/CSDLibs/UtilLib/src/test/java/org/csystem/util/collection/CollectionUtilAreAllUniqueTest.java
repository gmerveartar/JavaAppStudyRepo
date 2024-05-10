package org.csystem.util.collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

// @Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class CollectionUtilAreAllUniqueTest {
    static class DataInfo {
        List <String> str;
        boolean expected;

        public DataInfo(boolean expected, List<String> str)
         {
            this.str = str;
            this.expected = expected;
        }
    }

    public CollectionUtilAreAllUniqueTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    public DataInfo dataInfo;
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(true, new ArrayList<>(){{add("ankara"); add("izmir"); add("istanbul");}}),
                new DataInfo( false, new ArrayList<>(){{add("ankara"); add("izmir"); add("ankara");}}),
                new DataInfo( false, new ArrayList<>(){{add(""); add("");}}),
                new DataInfo( true, new ArrayList<>(){{add("");}})
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, CollectionUtil.areAllUnique(dataInfo.str));
    }
}
