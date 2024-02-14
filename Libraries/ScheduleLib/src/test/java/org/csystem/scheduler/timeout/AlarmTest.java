package org.csystem.scheduler.timeout;

import com.karandev.io.util.console.Console;
import org.junit.Test;

import java.time.LocalDateTime;

public class AlarmTest {

    @Test
    public void test() throws InterruptedException
    {
        var dateTime = LocalDateTime.now().plusSeconds(5);
        var alarm = Alarm.of(dateTime);

        alarm.start(() -> Console.writeLine("Alarm..!"));

        Thread.sleep(6000);
    }
}
