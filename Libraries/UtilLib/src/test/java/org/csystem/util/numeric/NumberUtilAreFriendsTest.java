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
public class NumberUtilAreFriendsTest {
    static class DataInfo {
        int input1;
        int input2;
        boolean expected;

        public DataInfo(int input1, int input2, boolean expected) {
            this.input1 = input1;
            this.input2 = input2;
            this.expected = expected;
        }
    }

    public NumberUtilAreFriendsTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    public DataInfo dataInfo;
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(220, 284, true),
                new DataInfo(1184, 1210, true),
                new DataInfo(2620, 2924, true),
                new DataInfo(2, 4, false)
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected,NumberUtil.areFriends(dataInfo.input1, dataInfo.input2));
    }
}
