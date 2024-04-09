/*----------------------------------------------------------------
	FILE		: CSDBoundedStack.java
	AUTHOR		: JavaApp1-Nov-2023 Group
	LAST UPDATE	: 24th Mar 2024

	CSDBoundedStack class

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.collection;

import org.csystem.collection.exception.FullStackException;
import java.util.EmptyStackException;

public class CSDBoundedStack<E>  {
    private static final boolean DEBUG = true;
    private final E[] m_elements;
    private int m_top;
    @SuppressWarnings("unchecked")
    public CSDBoundedStack(int n)
    {
        m_elements = (E[])new Object[n];
    }

    public boolean empty()
    {
        return m_top == 0;
    }

    public E push(E e)
    {
        if (DEBUG)
            assert m_top <= m_elements.length:   "Invalid modification for top index";
        if (m_top == m_elements.length)
            throw new FullStackException();

        m_elements[m_top++] = e;
        return e;
    }

    public E pop()
    {
        if (empty())
            throw new EmptyStackException();

        var element = m_elements[--m_top];

        m_elements[m_top] = null;

        return element ;
    }

    public E peek()
    {
        if (empty())
            throw new EmptyStackException();

        return m_elements[m_top - 1];
    }
    public int search(E e)
    {
        if (e == null) {
            for (var i = m_top - 1; i >= 0; --i)
                if (m_elements[i] == null)
                    return m_top - i;
        }
        else
            for (var i = m_top - 1; i >= 0; --i)
                if (e.equals(m_elements[i]))
                    return m_top - i;
        return -1;
    }
}
