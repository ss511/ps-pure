package com.shashank.ps.leetCode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("ABC", 1));
    }

    private static String convert(String s, int numRows) {
        int sSize = s.length();
        if (sSize < 3 || numRows < 2 || sSize <= numRows) {
            return s;
        }
        char[] sC = s.toCharArray();
        int inc = numRows+(numRows-2);
        char[] res = new char[sSize];
        int k = 0;
        for (int i = 0; i < numRows; i++ ) {
            int dInc = inc-(i*2) == 0? inc: inc-(i*2);
            int j = i;
            while (j < sSize && k < sSize) {
                res[k] = sC[j];
                k++;
                j += dInc;
                dInc = inc == dInc? dInc: inc-dInc;
            }
        }
        return new String(res);
    }
}
