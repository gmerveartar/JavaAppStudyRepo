package org.csystem.app.generator.random.text.runner;


import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.scheduler.Scheduler;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.random.RandomGenerator;

@Component
@Slf4j
public class TextGeneratorRunner implements ApplicationRunner {
    private final Scheduler m_scheduler;
    private final RandomGenerator m_random;

    @Value("${gen.min}")
    private int m_min;

    @Value("${gen.bound}")
    private int m_bound;

    private void schedulerCallBack()
    {
        try {
            var text = StringUtil.generateRandomTextEN(m_random, m_random.nextInt(m_min, m_bound));
            Console.writeLine("Generated Text:%s", text);
        }
        catch (Throwable ex) {
            m_scheduler.cancel();
            log.error("Exception occurred:{}", ex.getMessage());
        }
    }

    public TextGeneratorRunner(Scheduler scheduler, RandomGenerator random)
    {
        m_scheduler = scheduler;
        m_random = random;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_scheduler.schedule(this::schedulerCallBack);
    }
}
