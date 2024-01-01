package org.csystem.recursion.util;

public class RecursionUtil {
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


    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        return n * factorial(n - 1);
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
    public static void writeReverse(String s)
    {
        writeReverse(s, 0);
    }


}
