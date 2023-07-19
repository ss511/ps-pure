package com.shashank.ps.leetCodeMedium;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Examples:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Input: height = [1,1]
 * Output: 1
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights1 = {1,8,6,2,5,4,8,3,7};
        int[] heights2 = {1,1};
        System.out.println(maxArea(heights1));
        System.out.println(maxArea(heights2));
    }

    private static int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;

        int max = 0;
        int temp;

        while (start < end) {
            temp = Math.min(height[start], height[end])*(end-start);
            max = Math.max(temp, max);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max;
    }
}
