package org.csystem;

import com.karandev.io.util.console.Console;
import org.csystem.birthday.reminder.BirthdayOperations;
public class Application {
    private static void printBirthdayMessage(BirthdayOperations operations)
    {
        var status = operations.getStatus();
        var age = operations.getAge();

        switch (status) {
            case BEFORE -> Console.writeLine("Happy birthday in advance. Your age : %.02f ", age);
            case AFTER -> Console.writeLine("Happy belated birthday. Your age : %.02f ", age);
            case TODAY -> Console.writeLine("Happy birthday. Your age : %.0f ", age);
        }
    }
    public static void run()
    {
        var day = Console.readInt("Input day : ", "Invalid day");
        var month = Console.readInt("Input month : ", "Invalid month");
        var year = Console.readInt("Input year : ", "Invalid year");

        printBirthdayMessage(new BirthdayOperations(day, month, year));
    }

}
