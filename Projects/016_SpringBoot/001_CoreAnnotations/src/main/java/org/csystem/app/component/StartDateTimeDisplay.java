package org.csystem.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class StartDateTimeDisplay {
    private final LocalDateTime m_StartDateTime;
    private final DateTimeFormatter m_formatter;

    public StartDateTimeDisplay(LocalDateTime localDateTime, DateTimeFormatter formatter)
    {
        m_StartDateTime = localDateTime;
        m_formatter = formatter;
    }
    @PostConstruct
    public void startDisplay()
    {
        Console.writeLine("Start Time : %s", m_StartDateTime.format(m_formatter));
    }
}
