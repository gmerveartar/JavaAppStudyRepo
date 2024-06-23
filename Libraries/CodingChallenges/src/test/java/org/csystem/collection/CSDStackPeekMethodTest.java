package org.csystem.collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CSDStackPeekMethodTest {
    private DataInfo m_dataInfo;

    static class DataInfo {
        CSDStack<Integer> values;
        Integer expected;
        public DataInfo(int a, int b, int expected)
        {
            values = new CSDStack<>();

            for (var i = a; i <= b; ++i)
               values.push(i);
            this.expected = expected;
        }
    }
    public CSDStackPeekMethodTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> m_values ()
    {
        return List.of(new DataInfo(1, 10, 10), new DataInfo(1, 100, 100));
    }
    @Test
    public void test ()
    {
        Assert.assertEquals(m_dataInfo.expected, m_dataInfo.values.peek());
    }
}
