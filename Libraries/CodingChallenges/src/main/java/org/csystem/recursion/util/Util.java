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

    public static void writeReverse(String s)
    {
        for (int i = s.length() - 1; i >= 0; --i)
            System.out.print(s.charAt(i));
    }
}