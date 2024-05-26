package org.csystem.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateDisplay {
    public DateDisplay()
    {
        Console.writeLine("I'm a default ctor of DateDisplay");
    }
    @PostConstruct
    public void displayLocalDate()
    {
        var today = LocalDate.now();
        Console.writeLine("Display Date: %s", today.format(DateTimeFormatter.ISO_DATE));
    }
}
