package org.csystem;

import com.karandev.io.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        var xml = new XML.Builder()
                .setTag("EditText")
                .setAttribute("android:hint")
                .setAttributeValue("Input your name")
                .setValue("test")
                .build();

        Console.writeLine(xml);
        //...
    }
}

