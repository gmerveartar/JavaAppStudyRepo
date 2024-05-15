package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.datasource.factory.ProductFactory;
import java.io.IOException;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

public class StreamAPIProductStockFilterApp {
    private static void dataExistsCallBack(ProductFactory factory)
    {
        factory.PRODUCTS.stream()
                .filter(p -> p.getStock() > 0)
                .forEach(Console::writeLine);
    }
    private static void dataNotExistsCallBack()
    {
        Console.Error.writeLine("No data in file!.. ");
    }
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(1, args.length, "wrong number of arguments");

            ProductFactory
                    .loadFromTextFile(args[0])
                    .ifPresentOrElse(StreamAPIProductStockFilterApp::dataExistsCallBack, StreamAPIProductStockFilterApp::dataNotExistsCallBack);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid value!...");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO problem occured : %s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Problem occured : %s", ex.getMessage());
        }

    }
}

