package com.shashank.ps.dp;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 *
 * Answer is : Max obtained value = 24
 */
public class RodCutting {

    public static void main(String[] args) {

        int rodLength = 8;
        int[] costPerPiece = {3,5,8,9,10,17,17,20};
        System.out.println("Max obtained value: " + getMaxCost(costPerPiece, rodLength));
    }

    private static int getMaxCost(int[] price, int length) {

        int[] dp = new int[length];

        dp[0] = price[0];
        for (int i = 1; i < length; i++) {
            dp[i] = price[i];
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j - 1] + dp[j]);
            }
        }
        return dp[length-1];
    }
}
