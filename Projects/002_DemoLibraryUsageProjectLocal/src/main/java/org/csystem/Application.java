package org.csystem;

import com.karandev.io.util.console.Console;
class Application {
    public static void run(String[] args)
    {
        int a = Console.readInt("Input first number:", "Invalid entry");
        int b = Console.readInt("Input second number:", "Invalid entry");

        Console.writeLine("%d + %d = %d", a, b, a + b) ;
    }
}
