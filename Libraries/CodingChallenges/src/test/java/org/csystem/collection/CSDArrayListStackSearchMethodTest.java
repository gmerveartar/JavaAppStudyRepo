package org.csystem.collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CSDArrayListStackSearchMethodTest {
    private DataInfo m_dataInfo;
    static class DataInfo {
        CSDArrayListStack<Integer> values ;
        int value;
        int expected;
        public DataInfo(int a, int b, int value, int expected)
        {
            this.value = value;
            this.expected = expected;
            values = new CSDArrayListStack<>();

            for (var i = a; i <= b; ++i)
               values.push(i);
        }
    }
    public CSDArrayListStackSearchMethodTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> m_values()
    {
        return List.of(new DataInfo(1, 10, 9, 2),
                new DataInfo(1, 100,  101, -1),
                new DataInfo(1, 100,  94, 7 )
         );
    }

    @Test
    public void test()
    {
        Assert.assertEquals(m_dataInfo.expected, m_dataInfo.values.search(m_dataInfo.value));
    }
}
