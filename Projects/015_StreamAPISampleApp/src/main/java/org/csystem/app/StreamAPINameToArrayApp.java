package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.datasource.factory.NameFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.time.format.DateTimeParseException;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

public class StreamAPINameToArrayApp {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(2, args.length, "wrong number of arguments");

            var factory = NameFactory.loadFromTextFile(Path.of(args[0]));
            var text = args[1];

            var list = factory.NAMES.stream().filter(v -> v.toLowerCase().contains(text)).toArray();
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

