package com.shashank.ps.leetCodeMedium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Hence its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */
public class LongestConsecutiveNumbersSequence {
    public static void main(String[] args) {
        int[] nums1 = {100,4,200,1,3,2};
        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};

        System.out.println(longestConsecutive(nums1));
        System.out.println(longestConsecutive(nums2));
    }

    private static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> aux = new HashSet<>();
        for (int num: nums) {
            aux.add(num);
        }

        int result = 0;
        for (Integer num: aux) {
            if (!aux.contains(num-1)) {
                int current = num;
                int streak = 1;

                while (aux.contains(current+1)) {
                    current = current+1;
                    streak++;
                }
                result = Math.max(result, streak);
            }
        }

        return result;
    }
}
