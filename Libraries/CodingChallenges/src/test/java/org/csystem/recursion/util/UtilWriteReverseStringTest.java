package org.csystem.recursion.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class UtilWriteReverseStringTest {
    String str;

    public UtilWriteReverseStringTest(String str) {
        this.str = str;
    }

    @Parameterized.Parameters
    public static Collection<String> createData()
    {
        return List.of("ankara", "ali", "", "alipapila", "istanbul");
    }

    @Test
    public void test()
    {
        Util.writeReverse(str);
        System.out.println();
    }
}
