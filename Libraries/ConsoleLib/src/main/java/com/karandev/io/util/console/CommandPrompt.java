/*----------------------------------------------------------------------
	FILE        : CommandPrompt.java
	AUTHOR      : JavaApp-Nov-2023 Group
	LAST UPDATE : 29.02.2024

	General CommandPrompt class for REPL Framework

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.io.util.console;

import com.karandev.io.util.console.annotation.Command;
import com.karandev.io.util.console.annotation.ErrorCommand;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;

public final class CommandPrompt  {
    private Object m_regObject;
    private final ArrayList<CommandInfo> m_commandInfo = new ArrayList<>();
    private Method m_errorCommandMethod;
    private String m_prompt = "cmd";
    private String m_suffix = ">";
    private String m_parameterStringErrorMessage = "Message parameters must be String!...";
    private String m_wrongNumberOfArgumentsMessage = "Wrong number of arguments!...";
    private String m_invalidCommandErrorMessage = "Invalid Command!...";
    private static class CommandInfo {
        String commandText;
        Method method;
        int argCount;

        CommandInfo(String commandText, Method method, int argCount)
        {
            this.commandText = commandText;
            this.method = method;
            this.argCount = argCount;
        }
    }
    public static class Builder {
        private final CommandPrompt m_commandPrompt = new CommandPrompt();
        private Builder()
        {
        }
        public Builder setRegisterObject(Object regObject)
        {
            m_commandPrompt.registerObject(regObject);
            return this;
        }
        public Builder setPrompt(String prompt)
        {
            m_commandPrompt.m_prompt = prompt;
            return this;
        }
        public Builder setSuffix(String suffix)
        {
            m_commandPrompt.m_suffix = suffix;
            return this;
        }
        public Builder setParameterStringErrorMessage(String message)
        {
            m_commandPrompt.m_parameterStringErrorMessage = message;
            return this;
        }
        public Builder setWrongNumberOfArgumentsMessage(String message)
        {
            m_commandPrompt.m_wrongNumberOfArgumentsMessage = message;
            return this;
        }
        public Builder setInvalidCommandMessage(String message)
        {
            m_commandPrompt.m_invalidCommandErrorMessage  = message;
            return this;
        }
        public CommandPrompt create()
        {
            return m_commandPrompt;
        }
    }
    private boolean areAllString(Parameter [] parameters)
    {
        for (var parameter : parameters)
            if (parameter.getParameterizedType() != String.class)
                return false;
        return true;
    }
    private void runCommands(String [] cmdInfo) throws InvocationTargetException, IllegalAccessException
    {
        var parameters = Arrays.copyOfRange(cmdInfo, 1, cmdInfo.length);
        var flag = false;
        var argsFlag = false;

        for (var commandInfo: m_commandInfo)
            if (commandInfo.commandText.equals(cmdInfo[0])) {
                flag = true;
                argsFlag = true;

                if (commandInfo.argCount != parameters.length) {
                    argsFlag = false;
                    continue;
                }

                commandInfo.method.setAccessible(true);
                commandInfo.method.invoke(m_regObject, (Object[]) parameters);
                commandInfo.method.setAccessible(false);
                break;
            }
        if (!flag) {
            if (m_errorCommandMethod != null) {
                m_errorCommandMethod.setAccessible(true);
                m_errorCommandMethod.invoke(m_regObject);
                m_errorCommandMethod.setAccessible(false);
            }
            else
                Console.Error.writeLine(m_invalidCommandErrorMessage);
        }
        else if (!argsFlag)
            Console.Error.writeLine(m_wrongNumberOfArgumentsMessage);
    }
    private void registerCommands(Command [] commands, Method method)
    {
        for (var command : commands) {
            var value = command.value();
            var commandText = value.isBlank() ? method.getName() : value;
            var parameters = method.getParameters();

            if (!areAllString(parameters))
                throw new IllegalArgumentException(m_parameterStringErrorMessage);

            m_commandInfo.add(new CommandInfo(commandText, method, parameters.length));
        }
    }
    private void registerObject(Object regObject) 
    {
        m_regObject = regObject;    // neden builder içinde yapmadık?
        var clsRegObject = regObject.getClass();

        var methods = clsRegObject.getDeclaredMethods();
        for (var method : methods) {
            var commands = method.getDeclaredAnnotationsByType(Command.class);

            if (commands.length == 0) {
                if (m_errorCommandMethod == null && method.getDeclaredAnnotation(ErrorCommand.class) != null
                        && method.getParameters().length == 0)
                    m_errorCommandMethod = method;
                continue;
            }

            registerCommands(commands, method);
        }
    }
    private CommandPrompt()
    {
    }

    public static Builder createBuilder()
    {
        return new Builder();
    }
    public void run()
    {
        try {
            while (true) { 
                var cmd = Console.read(m_prompt + m_suffix);

                if (cmd.isBlank())
                    continue;
                runCommands(cmd.split("[ \t]+"));

            }

        }
        catch (Throwable ex) {
            throw new IllegalArgumentException(ex.getMessage(), ex);
        }
    }
}
