package org.csystem.util.bitwise;

import org.junit.Assert;
 import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class BitwiseUtilToBinaryStrIntTest {
    static class DataInfo {
        int a;
        String s;
         DataInfo(int a, String s) {
            this.a = a;
            this.s = s;
        }
    }
    public BitwiseUtilToBinaryStrIntTest(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    public DataInfo dataInfo;
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo(-10, "11111111111111111111111111110110"),
                new DataInfo(10, "00000000000000000000000000001010"),
                new DataInfo(0, "00000000000000000000000000000000"),
                new DataInfo(-1, "11111111111111111111111111111111")
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.s, BitwiseUtil.toBinaryStr(dataInfo.a));
    }
}
