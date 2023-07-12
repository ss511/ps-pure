package com.shashank.ps.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 *
 * Also, the solution should work whether the candidates have distinct integer or have duplicates.
 *
 * For example:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] arr1 = {2,3,5};
        int target1 = 7;

        int[] arr2 = {2,3,4,5};
        int target2 = 8;

        int[] arr3 = {2,3,6,7};
        int target3 = 7;

        System.out.println(combinationSum(arr1, target1));
        System.out.println(combinationSum(arr2, target2));
        System.out.println(combinationSum(arr3, target3));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results= new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), results, 0);

        return results;
    }

    private static void backtrack(int[] candidates, int target, List<Integer> result, List<List<Integer>> results, int start) {
        if (target == 0) {
            results.add(new ArrayList<>(result));
        } else if (target < 0) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i-1]) {
                    continue;
                }
                result.add(candidates[i]);
                backtrack(candidates, target-candidates[i], result, results, i);
                result.remove(result.size()-1);
            }
        }
    }
}
