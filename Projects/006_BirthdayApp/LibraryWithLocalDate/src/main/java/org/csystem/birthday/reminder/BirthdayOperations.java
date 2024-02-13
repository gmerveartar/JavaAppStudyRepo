package org.csystem.birthday.reminder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.csystem.birthday.reminder.BirthdayStatus.*;

public class BirthdayOperations {
    private final LocalDate m_birthDate;
    private final LocalDate m_today;
    public BirthdayOperations(int day, int month, int year)
    {
        m_birthDate = LocalDate.of(year, month, day);
        m_today = LocalDate.now();
    }
    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birthDate, m_today) / 365.;
    }
    public BirthdayStatus getStatus()
    {
        var birthDay = m_birthDate.withYear(m_today.getYear());
        var status = m_today.compareTo(birthDay);

        if (status < 0)
            return BEFORE;
        if (status > 0)
            return AFTER;
        return TODAY;
    }
}
