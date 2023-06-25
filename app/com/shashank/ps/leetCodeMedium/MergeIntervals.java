package com.shashank.ps.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * For example:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Input: intervals =
 * [[0,0],[1,2],[5,5],[2,4],[3,3],[5,6],[5,6],[4,6],[0,0],[1,2],[0,2],[4,5]]
 * Output: [[0,6]]
 *
 * Input: intervals =
 * [[1,3],[0,2],[2,3],[4,6],[4,5],[5,5],[0,2],[3,3]]
 * Output: [[0,3],[4,6]]
 */
public class MergeIntervals {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input1 = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] input2 = {{1,4},{4,5}};
        int[][] input3 = {{2,6}, {1,3}, {18,15}, {10, 16}};
        int[][] input4 = {{1,4}, {2,3}};
        int[][] input5 = {{1,4},{0,2},{3,5}};
        int[][] input6 = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        System.out.println(Arrays.deepToString(solution.merge(input1)));
        System.out.println(Arrays.deepToString(solution.merge(input2)));
        System.out.println(Arrays.deepToString(solution.merge(input3)));
        System.out.println(Arrays.deepToString(solution.merge(input4)));
        System.out.println(Arrays.deepToString(solution.merge(input5)));
        System.out.println(Arrays.deepToString(solution.merge(input6)));
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int i = 0;
        int j = 1;

        while (i < len) {
            int[] inner = new int[2];
            inner[0] = intervals[i][0];
            int temp = intervals[i][1];
            while (j < len && (intervals[i][1] >= intervals[j][0] || temp >= intervals[j][0])) {
                temp = Math.max(temp, intervals[j][1]);
                j++;
            }
            inner[1] = Math.max(intervals[i][1], temp);
            i = j;
            j++;
            result.add(inner);
        }
        return result.toArray(new int[result.size()][]);
    }
}