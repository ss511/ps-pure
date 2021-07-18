package com.shashank.ps.array;

/**
 * Find if a pivot exist in an int array so that sum of all left items is equal to sum of all right items.
 */
public class LeftRightSumPair {

    private static String balancedSums(int[] arr) {

        int left = 0;
        int sum = 0;

        for (int i: arr) {
            sum += i;
        }

        for (int i: arr) {
            if (2*left == sum-i) {
                return "YES";
            } else {
                left += i;
            }
        }
        return "NO";

    }

    public static void main(String[] args) {

        int[] arr1 = {5, 6, 8, 11};
        int[] arr2 = {1, 0, 0, 0};
        int[] arr3 = {1, 1, 4, 1, 1};
        int[] arr4 = {1, 2, 3};

        System.out.println(balancedSums(arr1));
        System.out.println(balancedSums(arr2));
        System.out.println(balancedSums(arr3));
        System.out.println(balancedSums(arr4));

    }
}
