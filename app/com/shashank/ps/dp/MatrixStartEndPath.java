package com.shashank.ps.dp;

/**
 * Given a binary matrix where mat[0][0] and mat[n-1][n-1] is always 1.
 * Find the number of path from mat[0][0] to mat[n-1][n-1],
 * where the cell with 0 acts as blocker and cant be used for traversing
 */
public class MatrixStartEndPath {

    public static void main(String[] args) {
        int[][] mat = {{1,1,0,1}, {1,1,1,1}, {0,1,1,1}, {1,0,1,1}};
        int n = 4;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }

        System.out.println("The number of possible path is: " + getPathCount(mat, dp, n, 0, 0));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int getPathCount(int[][] mat, int[][] dp, int n, int i, int j) {

        if (n == 0) {
            return 0;
        }

        if (i < 0 || j < 0 || i >= n || j >= n) {
            return 0;
        }

        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        if ( i == n-1 && j == n-1) {
            return 1;
        }

        if (j < n-1 && i < n-1 && mat[i][j+1] == 1 && mat[i+1][j] == 1) {
            dp[i][j] = getPathCount(mat, dp, n, i, j+1) + getPathCount(mat, dp, n, i+1, j);
        } else {
            if (j < n-1 && mat[i][j+1] == 1) {
                dp[i][j] = getPathCount(mat, dp, n, i, j + 1);
            }
            if (i < n-1 && mat[i+1][j] == 1) {
                dp[i][j] = getPathCount(mat, dp, n, i + 1, j);
            }
        }
        return dp[i][j];
    }
}
