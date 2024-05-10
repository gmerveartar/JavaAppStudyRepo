/*-------------------------------------------------------------
	FILE		: CollectionUtil.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 7th May 2024

	Utility class for collection operations

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.util.collection;

import java.util.Collection;
import java.util.HashSet;

public class CollectionUtil {
    private  CollectionUtil()
    {
    }

    public static <T> boolean areAllUnique (Collection<? extends T> collection)
    {
        return new HashSet<T>(collection).size() == collection.size();
    }
    public static <T> Collection<T> except (Iterable<? extends T> a, Iterable<? extends T> b)
    {
        throw new UnsupportedOperationException("TODO");
    }
    public static <T> boolean isEmpty(Collection<T> collection)
    {
        return collection.isEmpty();
    }
    public static <T> boolean isNotEmpty(Collection<T> collection)
    {
        return !isEmpty(collection) ;
    }
    public static <T> Collection<T> intersect (Iterable<? extends T> a, Iterable<? extends T> b)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public static <T> Collection<T> union(Iterable<? extends T> a, Iterable<? extends T> b)
    {
        throw new UnsupportedOperationException("TODO");
    }
    public static <T> Collection<T> unionAll(Iterable<? extends T> a, Iterable<? extends T> b)
    {
        throw new UnsupportedOperationException("TODO");
    }
}
