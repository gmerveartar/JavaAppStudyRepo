package org.csystem;


import java.util.TreeSet;
import java.util.random.RandomGenerator;

public class NumericLottery {
    private final RandomGenerator m_randomGenerator;

    public NumericLottery(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public int [] getNumbers()
    {
        var numbers = new int[6];
        var set = new TreeSet<Integer>();

        while (set.size() != 6)
            set.add(m_randomGenerator.nextInt(1, 50));

       for (var i = 0; i < 6; ++i)
           numbers[i] = set.pollFirst();

        return numbers;
    }
}
