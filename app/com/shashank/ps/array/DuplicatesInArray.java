package com.shashank.ps.array;

/**
 * Program to find duplicates in array without using extra space and in O(n) time.
 * Array size n.
 * Array items will always be within 0 to n-1
 */
public class DuplicatesInArray {

    public static void main(String[] args) {

        int[] arr = {1,2,3,1,3,6,6};
        printDuplicates(arr);
    }

    private static void printDuplicates(int[] arr) {

        int size = arr.length;

        for (int i = 0; i < size; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0) {
                arr[j] = -arr[j];
            } else {
                System.out.print(j + "\t");
            }
        }
    }
}
