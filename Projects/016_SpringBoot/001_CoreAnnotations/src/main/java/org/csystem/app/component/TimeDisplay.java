package org.csystem.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
@Lazy
class TimeDisplay {
    public TimeDisplay()
    {
        Console.writeLine("I'm a default ctor of TimeDisplay");
    }

    @PostConstruct
    public void displayLocalTime()
    {
        var now = LocalTime.now();
        Console.writeLine("Display Time: %s", now.format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
