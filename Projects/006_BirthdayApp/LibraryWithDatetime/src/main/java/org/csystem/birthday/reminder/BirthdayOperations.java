package org.csystem.birthday.reminder;

import org.csystem.util.datetime.legacy.DateTime;
import static org.csystem.birthday.reminder.BirthdayStatus.*;

public class BirthdayOperations {
    private static final double DIVIDER = 1000. * 60 * 60 * 24 * 365;
    private final DateTime m_birthDate;
    private final DateTime m_today;

    public BirthdayOperations(int day, int month, int year)
    {
        m_birthDate = DateTime.of(day, month, year );
        m_today = DateTime.today();
    }

    public double getAge()
    {
        return (m_today.getTimeInMillis() - m_birthDate.getTimeInMillis()) / DIVIDER;
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
