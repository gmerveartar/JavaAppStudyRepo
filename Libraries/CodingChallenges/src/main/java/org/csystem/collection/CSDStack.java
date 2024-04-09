 /*----------------------------------------------------------------
	FILE		: CSDStack.java
	AUTHOR		: JavaApp1-Nov-2023 Group
	LAST UPDATE	: 9th Apr 2024

	CSDStack class

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.collection;

 import java.util.ArrayList;
 import java.util.EmptyStackException;

 public class CSDStack<E> {
    private ArrayList<E> m_elements = new ArrayList<>();
    public boolean empty()
    {
        return m_elements.isEmpty();
    }

    public E push(E e)
    {
        m_elements.add(e);
        return e;
    }

    public E pop()
    {
        if (empty())
            throw new EmptyStackException();
        return m_elements.remove(m_elements.size() - 1);
        
    }

    public E peek()
    {
        if (empty())
            throw new EmptyStackException();
        return m_elements.get(m_elements.size() - 1);
    }
    public int search(E e)
    {
        var index = m_elements.indexOf(e);

        return index != -1 ? m_elements.size() - index : index;
     }
}
