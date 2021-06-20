package com.shashank.ps.array;

/**
 * Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.
 * {1, 4, 45, 6, 0, 19} and x = 51
 * Output: 3
 * Minimum length subarray is {4, 45, 6}
 */
public class SmallestSubArraySum {

    public static void main(String[] args) {

        int[] arr = {1,1,1,1,2,3};
        int xVal = 4;
        System.out.println("Smallest SubArray Size is: " + smallestSubWithSum(arr, arr.length, xVal));
    }

    private static int smallestSubWithSum(int[] arr, int n, int xVal)
    {
        int curr_sum = 0, minLen = n + 1;

        int start = 0, end = 0;
        while (end < n) {
            while (curr_sum <= xVal && end < n)
                curr_sum += arr[end++];

            while (curr_sum > xVal && start < n) {
                minLen = Math.min(minLen, end-start);
                curr_sum -= arr[start++];
            }
        }
        return minLen;
    }
}
