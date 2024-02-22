package org.csystem;

import org.csystem.commandprompt.CommandPrompt;

public class Application {
    public static void run()
    {
        var cp =  new CommandPrompt("csd");

        cp.run();
    }

}
