package com.shashank.ps.array;

/**
 * Finds the minimum value in a rotated sorted array.
 */
public class MinElementRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {5,6,1,2,3,4};
        System.out.println(getMin(arr));

    }

    private static int getMin(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while (start < end) {
            int mid = start + (end-start)/2;
            if (arr[mid] == arr[end]) {
                end--;
            } else if (arr[mid] > arr[end]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return arr[end];
    }
}
