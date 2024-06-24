package org.csystem.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
class DateDisplay {
    @Autowired // Field Injection
    private LocalDate m_localDate;

    @Value("${app.datetime.message.current.date:Date}")
    private String m_message;

    @PostConstruct
    public void displayLocalDate()
    {
        Console.writeLine("%s: %s", m_message, m_localDate.format(DateTimeFormatter.ISO_DATE));
    }
}
