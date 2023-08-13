package com.shashank.ps.leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class AllPossibleArraySubsets {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2,3,4,5,6};

        List<List<Integer>> subsets = subsets(nums1);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
        System.out.println("--------------------------------------------");
        subsets = subsets(nums2);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        computeSubset(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private static void computeSubset(int[] nums, List<List<Integer>> result, List<Integer> aux, int start) {
        result.add(new ArrayList<>(aux));
        for (int i = start; i < nums.length; i++) {
            aux.add(nums[i]);
            computeSubset(nums, result, aux, i+1);
            aux.remove(aux.size()-1);
        }
    }
}
