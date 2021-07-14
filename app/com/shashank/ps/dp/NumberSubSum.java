package com.shashank.ps.dp;

/**
 * Compute the sum of all substring of a given number represented as string.
 */
public class NumberSubSum {

    public static void main(String[] args) {
        System.out.println(computeSum("123"));
    }

    private static int computeSum(String n) {

        int nn = Integer.parseInt(n);

        int sum = 0;
        int i = 1;
        while (i < nn) {
            int temp = nn;
            int limit = i*10;
            while (temp > (i-1)) {
                System.out.println(temp%(limit));
                sum += temp%(limit);
                temp = temp/10;
            }
            i = i*10;
        }
        return sum;
    }
}
