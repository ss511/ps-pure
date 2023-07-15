package com.shashank.ps.leetCodeMedium;

/**
 * There is a robot on an m x n grid.
 * The robot is initially located in the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * Example:
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Input: m = 3, n = 2
 * Output: 3
 */
public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,3));
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(4,2));
    }

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
