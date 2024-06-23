/*-------------------------------------------------------------
	FILE		: IterableUtil.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 7th May 2024

	Utility class for iterable operations

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.util.iterable;

import java.util.Collection;
import java.util.HashSet;

public class IterableUtil {
    private IterableUtil()
    {
    }

    public static <T> boolean areAllUnigue (Iterable<? extends T> iterable)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public static <T> Iterable<T> except (Iterable<? extends T> a, Iterable<? extends T> b)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public static <T> boolean isEmpty(Iterable<T> iterable)
    {
        throw new UnsupportedOperationException("TODO");
    }
    
    public static <T> boolean isNotEmpty(Iterable<T> iterable)
    {
        return !isEmpty(iterable) ;
    }

    public static <T> Iterable<T> intersect (Iterable<? extends T> a, Iterable<? extends T> b)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public static <T> Iterable<T> union(Iterable<? extends T> a, Iterable<? extends T> b)
    {
        throw new UnsupportedOperationException("TODO");
    }
    public static <T> Iterable<T> unionAll(Iterable<? extends T> a, Iterable<? extends T> b)
    {
        throw new UnsupportedOperationException("TODO");
    }


}
