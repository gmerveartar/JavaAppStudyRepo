 package org.csystem.collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

 public class CSDArraylistAddTest {
     private CSDArrayList<Integer> m_elements;
     private int m_elementCount;
     @Before
     public void setUp()
     {
        m_elements = new CSDArrayList<>();

        for (var i = 0; i < 15; ++i) {
            m_elements.add(i * 2);
            ++m_elementCount;
        }
     }
     @Test
     public void test()
     {
         Assert.assertEquals(m_elementCount, m_elements.size());
     }

 }
