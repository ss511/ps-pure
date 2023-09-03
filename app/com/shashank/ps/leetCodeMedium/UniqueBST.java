package com.shashank.ps.leetCodeMedium;

/**
 * Given an integer n,
 * return the number of structurally unique BSTs which has exactly n nodes of unique values from 1 to n.
 *
 * Input: n = 3
 * Output: 5
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 * Input: n = 4
 * Output: 14
 */
public class UniqueBST {
    public static void main(String[] args) {
        System.out.println(numTrees(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
        System.out.println(numTrees(5));
        System.out.println(numTrees(6));
        System.out.println(numTrees(7));
    }

    private static int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}
