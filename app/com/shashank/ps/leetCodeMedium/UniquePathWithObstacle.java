package com.shashank.ps.leetCodeMedium;

/**
 * You are given an m x n integer array grid.
 * There is a robot initially located in the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * An obstacle and space are marked as 1 or 0 respectively in grid.
 * A path that the robot takes cannot include any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * For example:
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 *
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 */
public class UniquePathWithObstacle {
    public static void main(String[] args) {
        int[][] obstacleGrid1 = {{0,0,0}, {0,1,0}, {0,0,0}};
        int[][] obstacleGrid2 = {{0,1}, {0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid1));
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        int temp = 1;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                temp = 0;
            }
            dp[i][0] = temp;
        }

        temp = 1;
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                temp = 0;
            }
            dp[0][j] = temp;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
