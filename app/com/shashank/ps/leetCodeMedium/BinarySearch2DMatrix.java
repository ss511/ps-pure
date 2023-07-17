package com.shashank.ps.leetCodeMedium;

/**
 *You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * Example:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 */
public class BinarySearch2DMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int target1 = 4;

        int[][] matrix2 = {{1,2,3}, {4,5,6}, {9,18,20}};
        int target2 = 15;

        System.out.println(searchMatrix(matrix1, target1));
        System.out.println(searchMatrix(matrix2, target2));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        int cLen = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[len-1][cLen-1]) {
            return false;
        }
        int targetRow = -1;
        for (int i = 0; i < len; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][cLen-1]) {
                targetRow = i;
            }
        }
        if (targetRow == -1) {
            return false;
        }

        int start = 0;
        int end = cLen-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (target == matrix[targetRow][mid]) {
                return true;
            } else if (target < matrix[targetRow][mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
