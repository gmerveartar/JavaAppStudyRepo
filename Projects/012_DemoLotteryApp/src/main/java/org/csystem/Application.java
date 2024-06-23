package org.csystem;

import com.karandev.io.util.console.Console;

import java.util.Random;
import static org.csystem.util.array.ArrayUtil.print;

public class Application {
    public static void run(String[] args)
    {
        var random = new Random();
        var lottery = new NumericLottery(random);

        while (true) {
            var n = Console.readInt("Kaç tane kupon oynamak istersiniz:");

            if (n <= 0)
                break;

            for (var i = 0; i < n; ++i)
                print(2, lottery.getNumbers());
        }
    }
}
