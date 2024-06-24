/*-------------------------------------------------------------
	FILE		: ArrayUtil.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 24th May 2024

	Utility class for array operations

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.util.array;


import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.random.RandomGenerator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public final class ArrayUtil {
    private ArrayUtil()
    {}

    private static void bubbleSortAscending(int [] a)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] < a[k])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (a[k] < a[k + 1])
                    swap(a, k, k + 1);
    }

    private static void selectionSortAscending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i) {
            var min = a[i];
            var minIndex = i;

            for (var k = i + 1; k < a.length; ++k)
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static void selectionSortDescending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i) {
            var max = a[i];
            var maxIndex = i;

            for (var k = i + 1; k < a.length; ++k)
                if (max < a[k]) {
                    max = a[k];
                    maxIndex = k;
                }
            a[maxIndex] = a[i];
            a[i] = max;
        }
    }


    public static void addBy(int [] a, int val)
    {
        IntStream.range(0, a.length).forEach(i -> a[i] += val);
    }

    public static void addBy(int [][] a, int val)
    {
        Arrays.stream(a).forEach(array -> addBy(array, val));
    }
    public static <T> boolean areAllUnique(T [] a)
    {
        return Stream.of(a).distinct().count() == a.length;
    }

    public static boolean areAllUnique(int [] a)
    {
        return Arrays.stream(a).distinct().count() == a.length;
    }
    public static boolean areAllUnique(long [] a)
    {
        return Arrays.stream(a).distinct().count() == a.length;

    }
    public static boolean areAllUnique(double [] a)
    {
        return Arrays.stream(a).distinct().count() == a.length;

    }
     public static void bubbleSort(int [] a)
    {
        bubbleSort(a, false);
    }

    public static void bubbleSort(int [] a, boolean descending)
    {
        if (descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static void fillRandomArray(RandomGenerator randomGenerator, int [][] a, int min, int bound)
    {
        for (var i = 0; i < a.length; ++i)
            for (var k = 0; k < a[i].length; ++k)
                a[i][k] = randomGenerator.nextInt(min, bound);
    }

    public static void fillRandomArray(RandomGenerator randomGenerator, int [] a, int min, int bound)
    {
        for (var i = 0; i < a.length; ++i)
            a[i] = randomGenerator.nextInt(min, bound);
    }
    public static <T> void forEach(T[] a, Consumer<? super T> consumer)
    {
        Arrays.stream(a).forEach(consumer);
    }

    public static int [] generateRandomArray(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        return IntStream.generate(() -> randomGenerator.nextInt(min, bound)).limit(count).toArray();
    }

    public static long [] generateRandomArray(RandomGenerator randomGenerator, int count, long min, long bound)
    {
        return LongStream.generate(() -> randomGenerator.nextLong(min, bound)).limit(count).toArray();
    }

    public static double [] generateRandomArray(RandomGenerator randomGenerator, int count, double min, double bound)
    {
        return DoubleStream.generate(() -> randomGenerator.nextDouble(min, bound)).limit(count).toArray();
    }

    public static int [] histogramData(int [] a, int n)
    {
        var counts = new int[n + 1];

        Arrays.stream(a).forEach(v -> ++counts[v]);

        return counts;
    }

    public static void multiplyBy(int [] a, int val)
    {
        IntStream.range(0, a.length).forEach(i -> a[i] *= val);
    }

    public static void multiplyBy(int [][] a, int val)
    {
        Arrays.stream(a).forEach(array -> multiplyBy(array, val));
    }

    public static void reverse(int [] a)
    {
        var left = 0;
        var right = a.length - 1;

        while (left < right)
            swap(a, left++, right--);
    }

    public static void reverse(char [] a)
    {
        var left = 0;
        var right = a.length - 1;

        while (left < right)
            swap(a, left++, right--);
    }

    public static void selectionSort(int [] a)
    {
        selectionSort(a, false);
    }

    public static void selectionSort(int [] a, boolean descending)
    {
        if (descending)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static void subtractBy(int [] a, int val)
    {
        addBy(a, -val);
    }

    public static void subtractBy(int [][] a, int val)
    {
        addBy(a, -val);
    }

    public static int sum(int [] a)
    {
        return Arrays.stream(a).sum();
    }

    public static void swap(int [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }
}
