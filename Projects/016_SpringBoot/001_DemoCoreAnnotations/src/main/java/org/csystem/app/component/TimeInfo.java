package org.csystem.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
@Lazy
public class TimeInfo {
    public TimeInfo()
    {
        Console.writeLine("I'm a default ctor of TimeDisplay");
    }

    public void displayLocalTime()
    {
        var now = LocalTime.now();
        Console.writeLine("Time Display: %s", now.format(DateTimeFormatter.ISO_TIME));
    }
}
