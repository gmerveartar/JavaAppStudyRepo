package org.csystem;

import com.karandev.io.util.console.CommandPrompt;
import org.csystem.commandprompt.CommandsInfo;

public class Application {
    public static void run()
    {
        var cp = CommandPrompt.createBuilder()
                .setRegisterObject(new CommandsInfo())
                .setPrompt("csd")
                .setSuffix(">")
                .create();

        cp.run();
    }

}
