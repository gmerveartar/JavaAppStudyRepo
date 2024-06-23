package org.csystem.collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;
import java.util.Stack;

@RunWith(Parameterized.class)
public class CSDBoundedStackSearchTest {
    private DataInfo m_dataInfo;
    static class DataInfo {
        CSDBoundedStack<Integer> values ;
        Stack<Integer> stack;
        int value;
        public DataInfo(int n, int value)
        {
            this.value = value;
            stack = new Stack<>();
            values = new CSDBoundedStack<>(n);

            for (var i = 1; i <= n; ++i) {
                values.push(i);
                stack.push(i);
            }
        }
    }
    public CSDBoundedStackSearchTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> m_values()
    {
        return List.of(new DataInfo(10, 9),
                new DataInfo(100,  101),
                new DataInfo(100,  94)
         );
    }
    @Test
    public void test()
    {
        Assert.assertEquals(m_dataInfo.stack.search(m_dataInfo.value), m_dataInfo.values.search(m_dataInfo.value));
    }
}
