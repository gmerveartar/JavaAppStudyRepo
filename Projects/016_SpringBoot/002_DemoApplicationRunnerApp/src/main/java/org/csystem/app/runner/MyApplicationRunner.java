package org.csystem.app.runner;

import com.karandev.io.util.console.Console;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {
    private void optionValues(ApplicationArguments applicationArguments, String name)
    {
        Console.writeLine("%s: ", name);
        applicationArguments.getOptionValues(name).forEach(v -> Console.writeLine("\t%s", v));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        Console.writeLine("Component Application Runner");

        Console.writeLine("Option Arguments");
        args.getOptionNames().forEach(n -> optionValues(args, n));

        Console.writeLine("Non Option args");
        args.getNonOptionArgs().forEach(Console::writeLine);

        Thread.sleep(3000);
    }
}
