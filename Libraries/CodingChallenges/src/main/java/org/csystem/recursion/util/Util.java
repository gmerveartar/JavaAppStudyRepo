package org.csystem.recursion.util;

public class Util {
    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        var result = 1L;
        for ( ; n > 1; --n)
            result *= n;

        return result;
    }
    //0 1 1 2 3 5 8 13 21 ....
    public static int fibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        if (n <= 2)
            return n - 1;

        var prev1 = 1;
        var prev2 = 0;
        var result = 0;

        for (int i = 3; i <= n; ++i){
            result = prev1 + prev2;
            prev2 = prev1;
            prev1 = result;
        }

        return result;
    }
    public static int gcd (int a, int b)
    {
        var min = Math.min(Math.abs(a), Math.abs(b));
        for (int i = min; i > 1; --i)
            if (a % i == 0 && b % i == 0)
                return i;
        return 1;
    }
    public static String reverse(String s)
    {
        var chars = s.toCharArray();
        var left = 0;
        var right = s.length() - 1;

        while (left < right) {
            var temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return String.valueOf(chars);
    }
    public static void writeCollatz(int val)
    {
        while (val != 1) {
            System.out.print(val + " ");
            val = val % 2 == 0 ? val / 2 : 3 * val + 1;
        }
    }

    /*
        writeNumber method prints a number type int to stdout
        only by using system.out.write method (prints characters to stdout) and an array
        ps: it's not allowed to use bitwise operators
    */
    public static void writeNumber(int val)
    {
        if (val == 0)
            System.out.write('0');

        char [] s = new char[11];
        int i;
        var isNegative = false;

        if (val < 0) {
            isNegative = true;
            val = -val;
        }
        for (i = 0; val != 0; i++, val /= 10)
            s[i] = (char)(val % 10 + '0');

        if (isNegative)
            System.out.write('-');

        for ( ; i >= 0; --i)
            System.out.write(s[i]);
    }
    public static void writeReverse(String s)
    {
        for (int i = s.length() - 1; i >= 0; --i)
            System.out.print(s.charAt(i));
    }
}