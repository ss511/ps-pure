package com.shashank.ps.leetCodeMedium;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * For example
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 */
public class FirstAndLastPosSortedArray {

    public static void main(String[] args) {
        FirstAndLastPosSortedArray firstAndLastPosSortedArray = new FirstAndLastPosSortedArray();
        int[] arr1 = {5,7,7,8,8,10};
        int target1 = 8;

        int[] arr2 = {2, 2};
        int target2 = 3;

        System.out.println(Arrays.toString(firstAndLastPosSortedArray.searchRange(arr1, target1)));
        System.out.println(Arrays.toString(firstAndLastPosSortedArray.searchRange(arr2, target2)));
    }

    private int[] searchRange(int[] nums, int target) {

        int[] res = {-1,-1};
        int len = nums.length;

        if (nums.length == 0) {
            return res;
        }

        res[0] = findStartPos(nums, target, 0, len-1);
        res[1] = findEndPos(nums, target, 0, len-1);
        return res;
    }

    private int findStartPos(int[] nums, int target, int start, int end) {
        if (start <= end ) {
            int mid = (start+end)/2;

            int startPos = -1;

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    startPos = mid;
                } else {
                    startPos = findStartPos(nums, target, start, mid-1);
                }

            } else if (nums[mid] > target){
                startPos = findStartPos(nums, target, start, mid-1);
            } else {
                startPos = findStartPos(nums, target, mid+1, end);
            }
            return startPos;
        }

        return -1;
    }

    private int findEndPos(int[] nums, int target, int start, int end) {
        if (start <= end) {
            int mid = (start+end)/2;

            int endPos = -1;

            if (nums[mid] == target) {
                if (mid == nums.length-1 || (mid < nums.length-1 && nums[mid+1] > target)) {
                    endPos = mid;
                } else {
                    endPos = findEndPos(nums, target, mid+1, end);
                }

            } else if (nums[mid] > target){
                endPos = findEndPos(nums, target, start, mid-1);
            } else {
                endPos = findEndPos(nums, target, mid+1, end);
            }
            return endPos;
        }

        return -1;
    }
}
