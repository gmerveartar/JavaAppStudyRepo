package org.csystem.scheduler;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CountDownSchedulerTest {
    private int m_expected = 5;
    @Test
    public void test() throws InterruptedException
    {
        new CountDownScheduler(5, 1, TimeUnit.SECONDS) {
            public void onTick(long remainingMilliseconds)
            {
                System.out.printf("%d%n", remainingMilliseconds / 1000);
                --m_expected;
            }
            public void onFinish()
            {
                Assert.assertEquals(0, m_expected) ;
            }
        }.start();

        Thread.sleep(6000);
    }
}
