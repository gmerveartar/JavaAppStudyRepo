package org.csystem.scheduler.timeout;

import com.karandev.io.util.console.Console;
import org.junit.Test;

import java.time.LocalDateTime;

public class AlarmTest {

    @Test
    public void test() throws InterruptedException
    {
        var alarm = Alarm.of(LocalDateTime.now().plusSeconds(5));

        alarm.start(() -> Console.writeLine("Alarm..!"));

        Thread.sleep(6000);
    }
}
