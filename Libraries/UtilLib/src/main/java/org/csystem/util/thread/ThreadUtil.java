/*-------------------------------------------------------------
	FILE		: ThreadUtil.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 1st Dec 2023

	Utility class for thread operations

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/

package org.csystem.util.thread;

public final class ThreadUtil {
    private ThreadUtil()
    {}

    public static void sleep(long milliSeconds)
    {
        try {
            Thread.sleep(milliSeconds);
        }
        catch (InterruptedException ignore) {

        }
    }

}
