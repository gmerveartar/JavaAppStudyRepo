 package org.csystem.collection;

import org.csystem.collection.exception.FullStackException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;


 public class CSDBoundedStackPushThrowsExceptionTest {
     private CSDBoundedStack<Integer> m_stack;
     @Before
     public void setUp()
     {
        m_stack = new CSDBoundedStack<Integer>(10);

        for (var i = 0; i < 10; ++i)
            m_stack.push(i * 10);
     }
     @Test
     public void test ()
     {
         Assert.assertThrows(FullStackException .class, () -> m_stack.push(20));
     }

 }
