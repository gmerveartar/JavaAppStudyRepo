package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.datasource.factory.ProductFactory;

import java.io.IOException;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

public class StreamAPIProductStockMinMaxFilterApp {
    private static void dataExistsCallBack(ProductFactory factory, int minStock, int maxStock)
    {
        factory.PRODUCTS.stream()
                .filter(p -> p.getStock() > minStock)
                .filter(p -> p.getStock() <= maxStock)
                .forEach(Console::writeLine);
    }
    private static void dataNotExistsCallBack()
    {
        Console.Error.writeLine("No data in file!.. ");
    }
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(3, args.length, "wrong number of arguments");

            var minStock = Integer.parseInt(args[1]);
            var maxStock = Integer.parseInt(args[2]);

            ProductFactory
                    .loadFromTextFile(args[0])
                    .ifPresentOrElse(pf -> dataExistsCallBack(pf, minStock, maxStock), StreamAPIProductStockMinMaxFilterApp::dataNotExistsCallBack);
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

