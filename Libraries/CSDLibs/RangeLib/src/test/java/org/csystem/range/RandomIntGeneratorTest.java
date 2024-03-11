package org.csystem.range;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

public class RandomIntGeneratorTest {
    @Test
    public void givenValues_whenOriginBoundCountAndRandomGenerator_thenIterate()
    {
        var count = 100_000;
        var a = new int[count];
        var origin = 10;
        var bound = 100;
        var index = 0;

        for (int val : RandomIntGenerator.of(new Random(), origin, bound, count)) {
            // System.out.printf("%d ", val);
            a[index++] = val;
        }

        System.out.println();
        Assert.assertEquals(count, a.length);
        Assert.assertTrue(Arrays.stream(a).allMatch(val -> origin <= val && val < bound));

    }

}
