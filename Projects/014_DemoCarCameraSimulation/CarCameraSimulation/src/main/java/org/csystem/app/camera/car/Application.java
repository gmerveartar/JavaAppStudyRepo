package org.csystem.app.camera.car;


import com.karandev.io.util.console.Console;

import static com.karandev.io.util.console.CommandLineArgs.*;


public class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(1, args.length, "wrong number of arguments!... ");
        
        try {
            var simulation = new CarCameraApp();

            simulation.run(Integer.parseInt(args[0]));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid duration!...");
        }
      

    }
}
