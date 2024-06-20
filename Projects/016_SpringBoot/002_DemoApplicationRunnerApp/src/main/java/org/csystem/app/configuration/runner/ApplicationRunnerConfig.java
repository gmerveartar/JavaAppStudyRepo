package org.csystem.app.configuration.runner;

import com.karandev.io.util.console.Console;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationRunnerConfig {
    private void applicationRunnerCallBack(ApplicationArguments applicationArguments) throws InterruptedException
    {
        Console.writeLine("Bean Application Runner");
        Thread.sleep(3000);
    }

    @Bean
    public ApplicationRunner createApplicationRunner()
    {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception
            {
                Console.writeLine("Bean Application Runner");
                Thread.sleep(3000);
            }
        };
    }
}
