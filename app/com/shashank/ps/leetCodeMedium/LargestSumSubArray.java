package com.shashank.ps.leetCodeMedium;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * Example:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 */
public class LargestSumSubArray {
    public static void main(String[] args) {
        int[] num1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] num2 = {5,4,-1,7,8};
        System.out.println(maxSubArray(num1));
        System.out.println(maxSubArray(num2));
    }

    private static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int temp = nums[0];

        for (int i = 1; i < len; i++) {
            temp = Math.max(nums[i], temp + nums[i]);
            max = Math.max(max, temp);
        }
        return max;
    }
}
