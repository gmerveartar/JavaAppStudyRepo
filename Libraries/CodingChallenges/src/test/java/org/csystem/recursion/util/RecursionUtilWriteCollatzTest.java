package org.csystem.recursion.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class RecursionUtilWriteCollatzTest {
    int val;

    public RecursionUtilWriteCollatzTest(int val) {
        this.val = val;
    }

    @Parameterized.Parameters
    public static Collection<Integer> createData()
    {
        return List.of(72543);
    }

    @Test
    public void test()
    {
        RecursionUtil.writeCollatz(val);
        System.out.println();
    }
}
