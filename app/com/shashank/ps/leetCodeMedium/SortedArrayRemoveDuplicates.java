package com.shashank.ps.leetCodeMedium;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove some duplicates in-place such that each unique element appears at most the max duplicate allowed input.
 * The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Examples:
 * Input: nums = [1,1,1,2,2,3], 2
 * Output: 5, nums = [1,1,2,2,3,_]
 *
 * Input: nums = [0,0,1,1,1,1,2,3,3], 2
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 */
public class SortedArrayRemoveDuplicates {

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3};
        int maxDuplicateAllowed1 = 2;

        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        int maxDuplicateAllowed2 = 2;

        int[] nums3 = {1,1,1,1,2,2,2,3,3,3,3};
        int maxDuplicateAllowed3 = 3;

        System.out.println(removeDuplicates(nums1, maxDuplicateAllowed1));
        System.out.println(removeDuplicates(nums2, maxDuplicateAllowed2));
        System.out.println(removeDuplicates(nums3, maxDuplicateAllowed3));
    }

    private static int removeDuplicates(int[] nums, int maxDuplicateAllowed) {
        int len = nums.length;
        if (nums.length <= maxDuplicateAllowed) {
            return nums.length;
        }

        int slow = maxDuplicateAllowed;

        for (int fast = maxDuplicateAllowed; fast < len; fast++) {
            if (nums[fast] != nums[slow-maxDuplicateAllowed]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
