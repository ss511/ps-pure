package com.shashank.ps.hrPs;

import java.io.*;

/**
 * A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string.
 * Letters cannot be rearranged.
 * Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both?
 *
 * I/P - SHINCHAN & NOHARAAA
 * O/P - 3
 *
 */
class CommonChildResult {

    /**
     * Uses Longest Common Subsequence DP to solve the problem.g
     */
    public static int commonChild(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j ==0) {
                    dp[i][j] = 0;
                } else if (a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

}

public class CommonChild {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = CommonChildResult.commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

