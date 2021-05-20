package com.shashank.ps.dp;

/**
 * Program to find the longest common subsequence among two strings.
 * Don't confuse with sub-string.
 *
 * Here in the example string of a and b, the result is GTAB.
 */
public class LongestCommonSubsequence {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        String a = "AGGTAB";
        String b = "GXTXAYB";

        int subsequenceLength = longestCommonSubSequenceRecursion(a.toCharArray(), b.toCharArray(), a.length(), b.length());
        System.out.println("Longest Common Subsequence found using recursion is: " + subsequenceLength);

        subsequenceLength = longestCommonSubSequence(a.toCharArray(), b.toCharArray(), a.length(), b.length());
        System.out.println("Longest Common Subsequence found using recursion is: " + sb.reverse() + " of length: " + subsequenceLength);

    }


    //Efficient method using DP.
    private static int longestCommonSubSequence(char[] a, char[] b, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (a[i-1] == b[j-1]) {
                sb.append(a[i-1]);
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        return dp[m][n];
    }

    //Inefficient method using recursion.
    private static int longestCommonSubSequenceRecursion(char[] a, char[] b, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (a[m-1] == b[n-1]) {
            return 1 + longestCommonSubSequenceRecursion(a, b, m-1, n-1);
        } else {
            return Math.max(longestCommonSubSequenceRecursion(a, b, m-1, n), longestCommonSubSequenceRecursion(a, b, m, n-1));
        }
    }
}
