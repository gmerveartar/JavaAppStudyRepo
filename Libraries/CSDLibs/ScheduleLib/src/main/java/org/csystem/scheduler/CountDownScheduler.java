/*-------------------------------------------------------------
	FILE		: CountDownScheduler.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 8th Feb 2024

	CountDownScheduler class for count-down operations

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.scheduler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public abstract class CountDownScheduler {
    private final long m_millisInFuture;
    private final long m_countDownInterval;
    private final Timer m_timer;
    private TimerTask m_timerTask;
    protected CountDownScheduler(long durationInFuture, long countDownInterval, TimeUnit timeUnit)
    {
        this(timeUnit.toMillis(durationInFuture), timeUnit.toMillis(countDownInterval ));
    }
    protected CountDownScheduler(long millisInFuture, long countDownInterval)
    {
        m_timer = new Timer();
        m_millisInFuture = millisInFuture;
        m_countDownInterval = countDownInterval;
     }
    private TimerTask createTimerTask()
    {
        return new TimerTask() {
            long duration;
            public void run()
            {
                if (duration >= m_millisInFuture) {
                    onFinish();
                    cancel();
                    return;
                }

                duration += m_countDownInterval;
                onTick(m_millisInFuture - duration);


            }
        };
    }
    public abstract void onTick(long remainingMilliseconds);
    public abstract void onFinish();
    public final void start()
    {
        m_timer.scheduleAtFixedRate(createTimerTask(), 0, m_countDownInterval );
    }
    public final void cancel()
    {
        m_timer.cancel();
    }
}

