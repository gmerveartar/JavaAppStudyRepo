 package org.csystem.collection;

import org.csystem.collection.exception.FullQueueException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

 public class CSDBoundedQueueOfferFalseTest {
     private CSDBoundedQueue<Integer> m_queue;
     @Before
     public void setUp()
     {
        m_queue = new CSDBoundedQueue<>(10);

        for (var i = 0; i < 10; ++i)
            m_queue.add(i * 10);
     }
     @Test
     public void test ()
     {
         Assert.assertFalse((m_queue.offer(20)) );
     }

 }
