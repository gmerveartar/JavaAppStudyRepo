package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.datasource.factory.ProductFactory;
import org.csystem.util.datasource.factory.StaffFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

public class StreamAPIStaffFilterApp {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(3, args.length, "wrong number of arguments");

            var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            var minDate = LocalDate.parse(args[1], formatter);
            var maxDate = LocalDate.parse(args[2], formatter);
            var factory = StaffFactory.loadFromTextFile(args[0]);

            Arrays.stream(factory.getStaffAsArray())
                    .filter(s -> s.getBirthDate().isAfter(minDate))
                    .filter(s -> s.getBirthDate().isBefore(maxDate))
                    .forEach(Console::writeLine);

        }
        catch (DateTimeParseException ignore) {
            Console.Error.writeLine("Invalid date!...");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO problem occured : %s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Problem occured : %s", ex.getMessage());
        }

    }
}

