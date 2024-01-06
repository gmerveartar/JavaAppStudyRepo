package org.csystem.recursion.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class RecursionUtilWriteNumberTest {
    int val;

    public RecursionUtilWriteNumberTest(int val) {
        this.val = val;
    }

    @Parameterized.Parameters
    public static Collection<Integer> createData()
    {
        return List.of(0, -123, 123, -1234, 1234, 92634, -92634, 1, -1);
    }

    @Test
    public void test()
    {
        Util.writeNumber(val);
        System.out.println();
    }
}
