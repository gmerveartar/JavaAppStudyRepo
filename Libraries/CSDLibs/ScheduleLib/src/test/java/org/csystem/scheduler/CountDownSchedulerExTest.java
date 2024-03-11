package org.csystem.scheduler;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CountDownSchedulerExTest {
    private int m_expected = 5;
    @Test
    public void test() throws InterruptedException
    {
        new CountDownSchedulerEx(5, 1, TimeUnit.SECONDS) {
            @Override
            public void onStart()
            {
                 System.out.println("Scheduler started..!");
            }

            public void onTick(long remainingMilliseconds)
            {
                System.out.printf("%d%n", remainingMilliseconds / 1000);
                --m_expected;
            }
            public void onFinish()
            {
                Assert.assertEquals(0, m_expected) ;
            }
        }.startScheduler();

        Thread.sleep(6000);
    }
}
