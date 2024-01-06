package org.csystem.recursion.util;

public class RecursionUtil {
    private static int fibonacciNumberRecur(int n)
    {
        return n <= 2 ? n - 1 : fibonacciNumberRecur(n - 2) + fibonacciNumberRecur(n - 1);
    }

    private static int gcdRecur (int a, int b)
    {
       return b == 0 ? a : gcdRecur(b, a % b);
    }
    private static void reverse(char[] chars, int left, int right)
    {
        if(left >= right)
            return;

        var temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;

         reverse(chars, left + 1, right - 1);
    }
    private static void writeReverse(String s, int index)
    {
        if (index == s.length())
            return;

        writeReverse(s, index +1);
        System.out.print(s.charAt(index));
    }
    private static void writeNumberRecur(int val)
    {
        if (val / 10 != 0)
            writeNumberRecur(val / 10);

        System.out.write((char)(val % 10 + '0'));
    }
    public static long factorial(int n)
    {
        return n <= 0 ? 1 : n * factorial(n - 1);
    }
    public static int gcd (int a, int b)
    {
        return gcdRecur(Math.abs(a), Math.abs(b));
    }
    public static String reverse(String s)
    {
        var chars = s.toCharArray();

        reverse(chars, 0, s.length() - 1);

        return String.valueOf(chars);
    }
    public static void writeCollatz(int val)
    {
        if (val == 1)
            return;

        System.out.print(val + " ");

        val = val % 2 == 0 ? val / 2 : 3 * val + 1;

        writeCollatz(val);
    }
    /*
        writeNumber method prints a number type int to stdout
        only by using system.out.write method (prints characters to stdout) and an array
        ps: it's not allowed to use bitwise operators
    */
    public static void writeNumber(int val)
    {
        if (val < 0) {
            System.out.write('-');
            val = -val;
        }

        writeNumberRecur(val);
    }
    public static void writeReverse(String s)
    {
        writeReverse(s, 0);
    }
    public static int fibonacciNumber(int n)
    {
        return n <= 0 ? -1 : fibonacciNumberRecur(n);
    }

}
