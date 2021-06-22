package com.shashank.ps.array;

/**
 * Given an integer n, construct a matrix of size n x n with following conditions:
 * 1. Each cell contains an integer from 1 and n (inclusive).
 * 2. No integer appears twice in the same row or the same column.
 * 3. Centre of the matrix should not have 1
 */
public class MatrixConstruction {

    public static void main(String[] args) {
        int n = 4;

        int[][] mat = constructMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    private static int[][] constructMatrix(int n) {
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            int cellValue = i+1;
            int exceedValue = i+1;
            for (int j = 0; j < n; j++) {
                mat[i][j] = cellValue;

                cellValue++;
                exceedValue++;
                if (cellValue > n) {
                    cellValue = exceedValue-n;
                }
            }
        }

        return mat;
    }
}
