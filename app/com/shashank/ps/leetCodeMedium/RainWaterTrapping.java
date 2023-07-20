package com.shashank.ps.leetCodeMedium;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Examples:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] heights1 = {1,8,6,2,5,4,8,3,7};
        int[] heights2 = {1,1};
        System.out.println(trap(heights1));
        System.out.println(trap(heights2));
    }

    private static int trap(int[] height) {
        int len = height.length;

        if (len <= 2) {
            return 0;
        }

        int left = 0;
        int right = len-1;

        int result = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax-height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax-height[right];
                }
                right--;
            }
        }
        return result;
    }
}
