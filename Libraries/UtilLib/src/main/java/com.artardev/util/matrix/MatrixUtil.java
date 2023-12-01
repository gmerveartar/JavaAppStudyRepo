/*-------------------------------------------------------------
	FILE		: MatrixUtil.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 1st Dec 2023

	Utility class for matrix operations

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package com.artardev.util.matrix;

import com.artardev.util.array.ArrayUtil;

import java.util.random.RandomGenerator;


public final class MatrixUtil {
    private MatrixUtil()
    {
    }

    public static int[][] add(int[][] a, int [][] b)
    {
        var total = new int[a.length][a[0].length];

        for (var i = 0; i < a.length; ++i)
            for (var j = 0; j < a[i].length; ++j)
                total[i][j] = a[i][j] + b[i][j];

        return total;
    }

    public static void addBy(int [][] a, int val)
    {
        ArrayUtil.addBy(a, val);
    }

    public static int [][] generateRandomMatrix(RandomGenerator randomGenerator, int row, int col, int min, int bound)
    {
        var matrix = new int[row][col];

        ArrayUtil.fillRandomArray(randomGenerator, matrix, min, bound);

        return matrix;
    }

    public static int [][] generateRandomSquareMatrix(RandomGenerator randomGenerator, int n, int min, int bound)
    {
        return generateRandomMatrix(randomGenerator, n, n, min, bound);
    }

    public static boolean isMatrix(int [][] a)
    {
        var n = a[0].length;

        for (var i = 1; i < a.length; ++i)
            if (a[i].length != n)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a.length == a[0].length;
    }

    public static void multiplyBy(int [][] a, int val)
    {
        ArrayUtil.multiplyBy(a, val);
    }

    public static int[][] subtract(int[][] a, int [][] b)
    {
        var total = new int[a.length][a[0].length];

        for (var i = 0; i < a.length; ++i)
            for (var j = 0; j < a[i].length; ++j)
                total[i][j] = a[i][j] - b[i][j];

        return total;
    }

    public static void subtractBy(int [][] a, int val)
    {
        ArrayUtil.subtractBy(a, val);
    }

    public static int sum(int [][] a)
    {
        var total = 0;

        for (var rows : a)
            for (var val : rows)
                total += val;

        return total;
    }

    public static int sumDiagonal(int [][] a)
    {
        var total = 0;

        for (var i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static int [][] transposed(int [][] a)
    {
        var row = a.length;
        var col = a[0].length;
        var result = new int[col][row];

        for (var i = 0; i < row; ++i)
            for (var j = 0; j < col; ++j)
                result[j][i] = a[i][j];

        return result;
    }
}
