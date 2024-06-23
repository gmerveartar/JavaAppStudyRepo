/*----------------------------------------------------------------
	FILE		: CSDQueue.java
	AUTHOR		: JavaApp1-Nov-2023 Group
	LAST UPDATE	: 25th Mar 2024

	CSDQueue class

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free

	Yalnızca Object sınıfından türetilen, Queue<E> arayüzünü implemente eden ve dinamik olarak büyüyebilen
    CSDQueue sınıfını yazınız ve test ediniz
    Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz
----------------------------------------------------------------*/
package org.csystem.collection;

import java.util.*;

public class CSDQueue<E> implements Queue<E> {
    private final ArrayList<E> m_elements = new ArrayList<>();
    private int m_index;
    @Override
    public int size()
    {
        return m_index;
    }

    @Override
    public boolean isEmpty()
    {
        return m_index == 0;
    }

    @Override
    public boolean contains(Object o)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E>() {
            int index;
            @Override
            public boolean hasNext()
            {
                return index < m_index;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                return m_elements.get(index++);
            }
        };
    }

    @Override
    public Object[] toArray()
    {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public boolean remove(Object o)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        for (var e : c)
            add(e);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public void clear()
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean add(E e)
    {
         if (!m_elements.add(e))
             throw new IllegalStateException();
         m_index++;
         return true;
    }

    @Override
    public boolean offer(E e)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public E remove()
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public E poll()
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public E element()
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public E peek()
    {
        throw new UnsupportedOperationException("TODO");
    }
}
