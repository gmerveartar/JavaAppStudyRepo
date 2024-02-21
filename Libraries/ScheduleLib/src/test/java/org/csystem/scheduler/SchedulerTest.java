package org.csystem.scheduler;

import com.karandev.io.util.console.Console;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SchedulerTest {

    @Test
    public void test() throws InterruptedException
    {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        var scheduler = Scheduler.of(1000);

        scheduler.schedule(() -> Console.writeLine("%s\r", formatter.format(LocalDateTime.now())));

        Thread.sleep(6000);
    }
}
