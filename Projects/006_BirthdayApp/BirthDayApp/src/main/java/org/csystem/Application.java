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
    public static void run(String[] args)
    {
        int day = 0, month = 0, year = 0;
        if (args.length != 3 && args.length != 0) {
            Console.Error.writeLine("Wrong number of arguments");
            System.exit(1);
        }
        try {
            day = args.length == 3 ? Integer.parseInt(args[0]) : Console.readInt("Input day : ", "Invalid day");
            month = args.length == 3 ? Integer.parseInt(args[1]) : Console.readInt("Input month : ", "Invalid month");
            year = args.length == 3 ? Integer.parseInt(args[2]) : Console.readInt("Input year : ", "Invalid year");
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }

        printBirthdayMessage(new BirthdayOperations(day, month, year));
    }
}
