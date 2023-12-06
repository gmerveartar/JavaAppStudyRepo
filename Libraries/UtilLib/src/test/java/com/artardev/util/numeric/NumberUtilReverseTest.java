package com.artardev.util.numeric;


import com.artardev.util.numeric.data.IntIntDataInfo;
import com.artardev.util.numeric.data.IntLongDataInfo;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class NumberUtilReverseTest {
    IntIntDataInfo dataInfo;

    public NumberUtilReverseTest(IntIntDataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<IntIntDataInfo> createData()
    {
        return List.of(new IntIntDataInfo(123, 321),
                new IntIntDataInfo(112, 211),
                new IntIntDataInfo(111, 111),
                new IntIntDataInfo(23434,43432)
        );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(dataInfo.expected, NumberUtil.reverse(dataInfo.input));
    }
}
