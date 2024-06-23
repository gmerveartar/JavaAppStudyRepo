package org.csystem.collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CSDArrayListStackPopMethodEmptyTest {
    private DataInfo m_dataInfo;

    static class DataInfo {
        CSDArrayListStack<Integer> values;
        int total;
        int a;
        int b;
        public DataInfo(int a, int b, int total)
        {
            this.total = total;
            this.a = a;
            this.b = b;
            values = new CSDArrayListStack<>();

            for (var i = a; i <=  b; ++i)
               values.push(i);
        }
    }
    public CSDArrayListStackPopMethodEmptyTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> m_values ()
    {
        return List.of(new DataInfo(1, 10, 55), new DataInfo(1, 100, 5050));
    }

    private int calculateTotal()
    {
        int total = 0;
        while (!m_dataInfo.values.empty())
            total += m_dataInfo.values.pop();
        return total;
    }
    @Test
    public void givenStack_whenFilled_thenCalculateTotal()
    {
        Assert.assertEquals(m_dataInfo.total, calculateTotal());
    }
}
