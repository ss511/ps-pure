package com.shashank.ps.leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * For example
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * Output - 1 2 3 6 9 8 7 4 5
 */
public class MatrixSpiralOrder {

    public static void main(String[] args) {
        MatrixSpiralOrder matrixSpiralOrder = new MatrixSpiralOrder();

        int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix2 = {{1}, {2}, {3}};

        matrixSpiralOrder.spiralOrder(matrix1).forEach(System.out::println);
        System.out.println("--------");
        matrixSpiralOrder.spiralOrder(matrix2).forEach(System.out::println);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;

        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);

        int i = 0;
        int j = 0;

        int x = 0;
        int y = 0;

        int direction = 0;

        int counter = 1;

        while(counter < (m*n)) {
            counter++;
            if (i == x && j < n-y-1) {
                j++;
                result.add(matrix[i][j]);
                direction = 1;
            } else if (j == n-y-1 && i < m-x-1) {
                i++;
                result.add(matrix[i][j]);
                direction = 2;
            } else if (i == m-x-1 && j > y) {
                j--;
                result.add(matrix[i][j]);
                direction = 3;
            } else if (j == y && i > x-1) {
                i--;
                result.add(matrix[i][j]);
                direction = 4;
            }

            if (i == x+1 && j == y && direction == 4) {
                x++;
                y++;
            }
        }

        return result;
    }
}
