 /*----------------------------------------------------------------
	FILE		: CSDMinStack.java
	AUTHOR		: JavaApp1-Nov-2023 Group
	LAST UPDATE	: 9th Apr 2024

	CSDMinStack class

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free

	Tutulan en küçük elemanı O(1) karmaşıklıkta veren ve push ve pop işlemlerinin de en fazla "amortized O(1)""
    karmaşıklıkta çalıştığı CSDMinStack<E> sınıfını yazınız.
    Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz.
----------------------------------------------------------------*/
package org.csystem.collection;

 import java.lang.reflect.Array;
 import java.util.*;

 public class CSDMinStack<E> {
     private ArrayList<E> m_list = new ArrayList<>();
     private final ArrayList<E> m_minList = new ArrayList<>();
     private Comparator<E> m_comp;


     public boolean empty()
    {
        return m_list.isEmpty();
    }

    public E push(E e)
    {
        m_list.add(e);
        if (m_minList.isEmpty() ||  )
        ;
    }

    public E pop()
    {
        throw new UnsupportedOperationException("TODO");
    }

    public E peek()
    {
        throw new UnsupportedOperationException("TODO");
    }

    public E min(Comparator<? extends E> comp)
    {
        Collections.sort(m_list, comp);

        return m_list.get(0);
    }
    @Override
    private int compareTo()
    {
        return m_list
    }
 }
