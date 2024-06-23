/*----------------------------------------------------------------
	FILE		: CSDBoundedQueue.java
	AUTHOR		: JavaApp1-Nov-2023 Group
	LAST UPDATE	: 9th Apr  2024

	CSDBoundedQueue class

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.collection;

import org.csystem.collection.exception.FullQueueException;

import java.util.ArrayDeque;

public class CSDBoundedQueue<E> {
    private final ArrayDeque<E> m_elements;
    private final  int m_size;
    public CSDBoundedQueue(int n)
    {
        m_elements = new ArrayDeque<>(m_size = n);
     }

    public void add(E e)
    {
        if (m_elements.size() == m_size )
            throw new FullQueueException();

        m_elements.addLast(e);
    }
    public boolean offer(E e)
    {
        if (m_elements.size() == m_size)
            return false;

        m_elements.addLast(e);
        return true;
    }
    public E remove()
    {
        return m_elements.removeFirst();
    }
    public E poll()
    {
        return m_elements.pollFirst();
    }
    public E element()
    {
        return m_elements.getFirst();
    }
    public E peek()
    {
        return m_elements.peekFirst();
    }
}
