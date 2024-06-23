/*-------------------------------------------------------------
	FILE		: Generator.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 8th Mar 2024

	Generic iterable Generator class

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.generator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public abstract class BaseGenerator<T> implements Iterable<T> {
    protected Supplier<T> supplier;
    protected String noSuchElementExceptionMessage;
    protected BaseGenerator()
    {
    }
}
