/*-------------------------------------------------------------
	FILE		: ArrayUtil.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 16th May 2024

	Utility class for array operations

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.util.array;


import java.util.Arrays;
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

    public static void drawHistogram(int [] data, int n, char ch)
    {
        var maxVal = max(data);

        for (var val : data) {
            var count = (int)Math.floor(val * n / (double)maxVal);

            while (count-- > 0)
                System.out.print(ch);

            System.out.println();
        }
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

        for (var val : a)
            ++counts[val];

        return counts;
    }

    public static int max(int [] a)
    {
        return Arrays.stream(a).max().getAsInt();
    }

    public static int min(int [] a)
    {
        return Arrays.stream(a).min().getAsInt();
    }

    public static void multiplyBy(int [] a, int val)
    {
        for (var i = 0; i < a.length; ++i)
            a[i] *= val;
    }

    public static void multiplyBy(int [][] a, int val)
    {
        for (var array : a)
            multiplyBy(array, val);
    }

    public static int partitionByThresholdGreater(int [] a, int threshold)
    {
        var partitionIndex = 0;

        for (; partitionIndex < a.length && a[partitionIndex] > threshold; ++partitionIndex)
            ;

        if (partitionIndex == a.length)
            return partitionIndex;

        for (var i = partitionIndex + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, i, partitionIndex++);

        return partitionIndex;
    }

    public static int partitionByThresholdLess(int [] a, int threshold)
    {
        var partitionIndex = 0;

        for (; partitionIndex < a.length && a[partitionIndex] < threshold; ++partitionIndex)
            ;

        if (partitionIndex == a.length)
            return partitionIndex;

        for (var i = partitionIndex + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, i, partitionIndex++);

        return partitionIndex;
    }

    public static void print(int n, int [] a)
    {
        var fmt = String.format("%%0%dd ", n);

        for (var val : a)
            System.out.printf(fmt, val);

        System.out.println();
    }

    public static void print(int [] a)
    {
        print(a, " ", "\n");
    }

    public static void print(int [] a, String sep, String end)
    {
        for (var val : a)
            System.out.printf("%d%s", val, sep);

        System.out.print(end);
    }

    public static void print(double [] a)
    {
        for (var val : a)
            System.out.printf("%f%n", val);
    }

    public static void print(long [] a)
    {
        for (var val : a)
            System.out.printf("%d%n", val);
    }

    public static void print(int [][] a)
    {
        print(1, a);
    }

    public static void print(int n, int [][] a)
    {
        for (var array : a)
            print(n, array);
    }

    public static void print(String [] str)
    {
        print(str, "\n", "");
    }

    public static void print(String [] str, String sep, String end)
    {
        for (var s : str)
            System.out.printf("%s%s", s, sep);

        System.out.print(end);
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
        var total = 0;

        for (var val : a)
            total += val;

        return total;
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
