package org.csystem.generator.random;

import org.csystem.generator.random.RandomDoubleGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class RandomDoubleGeneratorTest {
    @Test
    public void givenValues_whenOriginBoundCountAndRandomGenerator_thenIterate()
    {
        var count = 10_000;
        var a = new double[count];
        var origin = 2.3456;
        var bound = 2.3556;
        var index = 0;

        for (double val : RandomDoubleGenerator .of(new Random(), origin, bound, count)) {
            a[index++] = val;
        }

        System.out.println();
        Assert.assertEquals(count, a.length);
        Assert.assertTrue(Arrays.stream(a).allMatch(val -> origin <= val && val < bound));

    }

}
