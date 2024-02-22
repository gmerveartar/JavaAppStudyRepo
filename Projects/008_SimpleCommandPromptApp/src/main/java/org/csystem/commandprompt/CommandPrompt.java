package org.csystem.commandprompt;

import com.karandev.io.util.console.Console;
import java.util.ArrayList;

public class CommandPrompt {
    private static final ArrayList<CommandInfo> COMMANDS = new ArrayList<>();
    private static void  fillCommands(CommandPrompt commandPrompt)
    {
        COMMANDS.add(new CommandInfo("length", CommandPrompt::lengthCallBack));
        COMMANDS.add(new CommandInfo("reverse", CommandPrompt::reverseCallBack));
        COMMANDS.add(new CommandInfo("upper", CommandPrompt::upperCallBack));
        COMMANDS.add(new CommandInfo("lower", CommandPrompt::lowerCallBack));
        COMMANDS.add(new CommandInfo("quit", CommandPrompt::quitCallBack));
        COMMANDS.add(new CommandInfo("chpr", commandPrompt::changePromptCallBack));
    }
    private String m_prompt;
    private static String [] parseCommandStr(String cmdStr)
    {
        return cmdStr.split("[ \t]+");
    }
    private void parseCommand(String [] cmdInfo)
    {
        var index = COMMANDS.indexOf(new CommandInfo(cmdInfo[0]));
        if (index != -1)
            COMMANDS.get(index).commandConsumer.accept(cmdInfo);
        else
            Console.Error.writeLine("Invalid Command");
    }

    private static void lengthCallBack(String [] cmdInfo)
    {
        if (cmdInfo.length <= 2)
            Console.writeLine(cmdInfo[1].length());
        else
            Console.writeLine("Invalid arguments for length command");
    }
    private static void reverseCallBack(String [] cmdInfo)
    {
        if (cmdInfo.length <= 2)
            Console.writeLine(new StringBuilder(cmdInfo[1]).reverse());
        else
            Console.writeLine("Invalid arguments for reverse command");
    }
    private static void upperCallBack(String [] cmdInfo)
    {
        if (cmdInfo.length <= 2)
            Console.writeLine(cmdInfo[1].toUpperCase());
        else
            Console.writeLine("Invalid arguments for upper command");
    }
    private static void lowerCallBack(String [] cmdInfo)
    {
        if (cmdInfo.length <= 2)
            Console.writeLine(cmdInfo[1].toLowerCase());
        else
            Console.writeLine("Invalid arguments for lower command");
    }
    private static void quitCallBack(String [] cmdInfo)
    {
        Console.writeLine("C and System Programmers Association");
        Console.writeLine("Thanks");
        System.exit(0);
    }
    private void changePromptCallBack(String [] cmdInfo)
    {
        if (cmdInfo.length <= 2)
            m_prompt = cmdInfo[1];
        else
            Console.writeLine("Invalid arguments for chpr command");
    }
    public CommandPrompt(String prompt)
    {
        m_prompt = prompt;
    }

    public void run()
    {
        fillCommands(this);
        while (true) {
            var cmdStr = Console.read (m_prompt + ">");

            parseCommand(parseCommandStr(cmdStr));
        }
    }
}
