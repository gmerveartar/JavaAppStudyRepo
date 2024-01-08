package org.csystem.util.bitwise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class BitwiseUtilToBinaryStrLongTest {
    static class DataInfo {
        long a;
        String s;
         DataInfo(long a, String s) {
            this.a = a;
            this.s = s;
        }
    }
    public BitwiseUtilToBinaryStrLongTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }
    DataInfo dataInfo;
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(-10, "1111111111111111111111111111111111111111111111111111111111110110"),
                new DataInfo(10, "0000000000000000000000000000000000000000000000000000000000001010"),
                new DataInfo(0, "0000000000000000000000000000000000000000000000000000000000000000"),
                new DataInfo(-1, "1111111111111111111111111111111111111111111111111111111111111111")
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.s, BitwiseUtil.toBinaryStr(dataInfo.a));
    }
}
