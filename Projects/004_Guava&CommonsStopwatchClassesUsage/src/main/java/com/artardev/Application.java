package com.artardev;

import com.artardev.util.numeric.NumberUtil;
import com.google.common.base.Stopwatch;
import com.karandev.io.util.console.Console;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

class Application {
    public static void run(String[] args)
    {
        ApplicationGoogleGuava.run();
        Console.writeLine("--------------------------");
        ApplicationApacheCommons.run();
    }
}
class ApplicationGoogleGuava {
    public static void run()
    {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Console.writeLine(NumberUtil.isPrime(1_603_318_868_174_368_979L) ? "Prime" : "Not Prime");
        stopwatch.stop();

        Console.writeLine("Elapsed time : %d seconds", stopwatch.elapsed(TimeUnit.SECONDS));
    }
}
class ApplicationApacheCommons {
    public static void run()
    {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Console.writeLine(NumberUtil.isPrime(1_603_318_868_174_368_979L) ? "Prime" : "Not Prime");
        stopWatch.stop();

        Console.writeLine("Elapsed time : %f seconds", stopWatch.getTime()/1000.);

    }
}