package org.csystem.range;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.random.RandomGenerator;

public class RandomIntGeneratorTest {
    @Test
    public void givenValues_whenOriginBoundCountAndRandomGenerator_thenIterate()
    {
        var count = 10;
        var a = new int[count];
        var index = 0;

        for (int val : RandomIntGenerator.of(new Random(), 0, 100, count)) {
            System.out.printf("%d ", val);
            a[index++] = val;
        }

        System.out.println();
        Assert.assertEquals(count, a.length);

    }

}
