package com.shashank.ps.leetCodeMedium;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 */
public class MatrixMinPathSum {

    public static void main(String[] args) {
        int[][] arr1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};

        System.out.println(minPathSum(arr1));
        System.out.println(minPathSum(arr2));
    }

    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}
