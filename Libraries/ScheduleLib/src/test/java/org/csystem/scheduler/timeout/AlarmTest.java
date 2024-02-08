package org.csystem.scheduler.timeout;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.TimerTask;

public class AlarmTest {

    @Test
    public void test() throws InterruptedException
    {
        var dateTime = LocalDateTime.now().plusSeconds(5);
        var alarm = new Alarm(dateTime);
        alarm.start(new TimerTask() {
            public void run()
            {
                System.out.println("Alarm..!");
            }
        });

        Thread.sleep(6000);
    }
}
