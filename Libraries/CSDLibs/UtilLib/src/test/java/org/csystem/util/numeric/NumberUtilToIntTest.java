package org.csystem.util.numeric;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;

// @Ignore("Tested before and passed")
@RunWith(Parameterized.class)
public class NumberUtilToIntTest {
    static class DataInfo {
        public String input;
        public OptionalInt expected;
        public DataInfo(String input, OptionalInt expected)
        {
            this.input = input;
            this.expected = expected;
        }
    }
    public DataInfo data;
    public NumberUtilToIntTest(DataInfo data) {
        this.data = data;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> createData()
    {
        return List.of(new DataInfo("a li",  OptionalInt.empty()),
                new DataInfo("10ali",  OptionalInt.empty()),
                new DataInfo("10",  OptionalInt.of(10)),
                new DataInfo("-10",  OptionalInt.of(-10))
        );
    } 
    @Test
    public void test()
    {
        Assert.assertEquals(data.expected, NumberUtil.toInt (data.input));
    }
}
