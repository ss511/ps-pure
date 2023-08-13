package com.shashank.ps.leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 */
public class AllPossibleKSizeArraySubsets {
    public static void main(String[] args) {
        List<List<Integer>> subsets = combine(4,2);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
        System.out.println("--------------------------------------------");
        subsets = combine(5,3);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }


    private static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        computeCombinations(n, result, new ArrayList<>(), 0, k);
        return result;
    }

    private static void computeCombinations(int n, List<List<Integer>> result, List<Integer> aux, int start, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(aux));
            return;
        }
        for (int i = start; i < n; i++) {
            aux.add(i+1);
            computeCombinations(n, result, aux, i+1, k-1);
            aux.remove(aux.size()-1);
        }
    }
}
