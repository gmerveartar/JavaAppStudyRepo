package com.karandev.datetime.configuration;

import static com.karandev.datetime.configuration.constant.BeanName.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class DateTimeConfig {
    @Bean(LOCAL_START_DATETIME_BEAN)
    public LocalDateTime startTime()
    {
        return LocalDateTime.now();
    }

    @Bean(LOCAL_CURRENT_DATETIME_BEAN)
    @Scope("prototype")
    public LocalDateTime currentDateTime()
    {
        return LocalDateTime.now();
    }

    @Bean(LOCAL_CURRENT_DATE_BEAN)
    @Scope("prototype")
    public LocalDate currentDate()
    {
        return LocalDate.now();
    }

    @Bean(LOCAL_CURRENT_TIME_BEAN)
    @Scope("prototype")
    public LocalTime currentTime()
    {
        return LocalTime.now();
    }

}
