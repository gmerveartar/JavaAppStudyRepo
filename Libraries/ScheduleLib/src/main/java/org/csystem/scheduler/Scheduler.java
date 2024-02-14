/*-------------------------------------------------------------
	FILE		: Scheduler.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 14th Feb 2024

	Scheduler class

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.scheduler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class Scheduler {
    private final Timer m_timer;
    private final long m_delay;
    private final long m_interval;
    private Scheduler(long delayInMillis, long intervalInMillis)
    {
        m_timer = new Timer();
        m_delay = delayInMillis;
        m_interval = intervalInMillis;
    }
    private TimerTask createTimerTask(Runnable task)
     {
        return new TimerTask() {
            public void run()
            {
                task.run();
            }
        };
    }
    public static Scheduler of(long interval, TimeUnit timeUnit)
    {
        return of(0, interval, timeUnit);
    }
    public static Scheduler of(long intervalInMillis)
    {
        return of(0, intervalInMillis);
    }
    public static Scheduler of(long delay, long interval, TimeUnit timeUnit)
    {
        return of(timeUnit.toMillis(delay), timeUnit.toMillis(interval));
    }
    public static Scheduler of(long delayInMillis, long intervalInMillis)
    {
       return new Scheduler(delayInMillis, intervalInMillis);
    }
    public final void schedule(Runnable task)
    {
        m_timer.scheduleAtFixedRate(createTimerTask(task), m_delay, m_interval);
    }
    public final void cancel()
    {
        m_timer.cancel();
    }
}
