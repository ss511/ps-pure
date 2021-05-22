package com.shashank.ps.dp;

/**
 * Find the longest path in a matrix. given we can only move in top, down, right or left direction. And the next cell value should be greater than just 1.
 *
 *{{2, 1, 9}
 *{4, 3, 8}
 *{5, 6, 7}}
 *
 * In this example, the longest path is 7, 3-4-5-6-7-8-9
 */
public class MatrixLongestPath {

    public static void main(String[] args) {
        int size = 3;
        int[][] mat = {{2,1,9}, {4,3,8}, {5,6,7}};

        System.out.println("The longest path is: " + getMatrixLongestPath(mat, size));
    }

    private static int getMatrixLongestPath(int[][] mat, int size) {

        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = -1;
            }
        }

        int result = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (dp[i][j] == -1) {
                    computePath(mat, dp, size, i, j);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    private static int computePath(int[][] mat, int[][] dp, int size, int i, int j) {
        if (i < 0 || j < 0 || i >= size || j >= size) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int top = Integer.MIN_VALUE;
        int down = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        int left = Integer.MIN_VALUE;

        if (j < size-1 && (mat[i][j] == mat[i][j+1]-1)) {
            right = dp[i][j] = 1 + computePath(mat, dp, size, i, j+1);
        }

        if (j > 0 && (mat[i][j] == mat[i][j-1]-1)) {
            left = dp[i][j] = 1 + computePath(mat, dp, size, i, j-1);
        }

        if (i < size-1 && (mat[i][j] == mat[i+1][j]-1)) {
            down = dp[i][j] = 1 + computePath(mat, dp, size, i+1, j);
        }

        if (i > 0 && (mat[i][j] == mat[i-1][j]-1)) {
            top = dp[i][j] = 1 + computePath(mat, dp, size, i-1, j);
        }

        return dp[i][j] = Math.max(top, Math.max(down, Math.max(right, Math.max(left, 1))));
    }

}
