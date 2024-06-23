package org.csystem.collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CSDArrayListStackPopMethodTest {
    private DataInfo m_dataInfo;

    static class DataInfo {
        CSDArrayListStack<Integer> values;
        int a;
        int b;
        public DataInfo(int a, int b)
        {
            this.a = a;
            this.b = b;
            values = new CSDArrayListStack<>();

            for (var i = a; i <=  b; ++i)
               values.push(i);
        }
    }
    public CSDArrayListStackPopMethodTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> m_values ()
    {
        return List.of(new DataInfo(1, 10), new DataInfo(1, 100));
    }

    @Test
    public void givenStack_whenFilled_thenPop()
    {
        Assert.assertEquals(m_dataInfo.b, (int)m_dataInfo.values.pop());
    }
}
