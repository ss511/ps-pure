package com.shashank.ps.leetCodeMedium;

import java.util.Arrays;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * if n = 3
 * output -
 * 1 2 3
 * 8 9 4
 * 7 6 5
 *
 */
public class GenerateSpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = generateMatrix(3);
        int[][] matrix2 = generateMatrix(4);

        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }
    }

    private static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int counter = 1;

        int left = 0;
        int top  = 0;
        int right = n - 1;
        int bottom = n - 1;

        while (counter <= n*n) {
            for (int i = left; i <= right; i++) {
                matrix[left][i] = counter;
                counter++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = counter;
                counter++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = counter;
                    counter++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = counter;
                    counter++;
                }
                left++;
            }
        }
        return matrix;
    }
}
