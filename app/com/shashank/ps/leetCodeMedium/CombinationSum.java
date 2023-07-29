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
 *
 * The V2 methods are for:
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 * Examples:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] arr1 = {2,3,5};
        int target1 = 7;

        int[] arr2 = {2,3,4,5};
        int target2 = 8;

        int[] arr3 = {2,3,6,7};
        int target3 = 7;

        int[] arr4 = {10,1,2,7,6,1,5};
        int target4 = 8;

        System.out.println(combinationSum(arr1, target1));
        System.out.println(combinationSum(arr2, target2));
        System.out.println(combinationSum(arr3, target3));

        System.out.println(combinationSumV2(arr1, target1));
        System.out.println(combinationSumV2(arr2, target2));
        System.out.println(combinationSumV2(arr4, target4));
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

    /**
     * This v2 will only give the unique combinations sum unlike the first method which can use 1 item as many times.
     */
    private static List<List<Integer>> combinationSumV2(int[] candidates, int target) {
        List<List<Integer>> results= new ArrayList<>();
        Arrays.sort(candidates);
        backtrackV2(candidates, target, new ArrayList<>(), results, 0);

        return results;
    }


    private static void backtrackV2(int[] candidates, int target, List<Integer> result, List<List<Integer>> results, int start) {
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
                backtrackV2(candidates, target-candidates[i], result, results, i+1);
                result.remove(result.size()-1);
            }
        }
    }
}
