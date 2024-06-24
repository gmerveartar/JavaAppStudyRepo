package org.csystem.collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CSDBoundedStackPopMethodTest {
    private DataInfo m_dataInfo;

    static class DataInfo {
        CSDBoundedStack<Integer> values;
        int n;
        int expected;
        public DataInfo(int n, int expected )
        {
            this.expected = expected;
            values = new CSDBoundedStack<>(n);

            for (var i = 1; i <= n; ++i)
               values.push(i);
        }
    }
    public CSDBoundedStackPopMethodTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> m_values ()
    {
        return List.of(new DataInfo(10, 10),
                new DataInfo(100, 100));
    }

    @Test
    public void givenStack_whenFilled_thenPop()
    {
        Assert.assertEquals(m_dataInfo.expected, (int)m_dataInfo.values.pop());
    }
}
