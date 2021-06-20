package com.shashank.ps.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds longest increasing subsequence in a standard array of integers.
 * I/P -> {50, 3, 10, 7, 40, 80}
 * O/P -> 4 {3, 10, 40, 80}
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {50, 3, 10, 7, 40, 80};

        List<Integer> resultList = getLongestIncreasingSubsequence(arr);
        System.out.println("SubSequence Length: " + resultList.size());
        System.out.println("SubSequence: ");
        for (Integer i : resultList) {
            System.out.print(i + "\t");
        }
    }

    private static List<Integer> getLongestIncreasingSubsequence(int[] arr) {

        int len = arr.length;
        List<Integer> resultList = new ArrayList<>();
        if (len == 0) {
            return resultList;
        }


        int count = 0;
        int index = 0;
        for (int i = 0; i < len; i++) {
            int tempCount = 0;
            int tempMax = arr[i];
            for (int j = i+1; j < len; j++) {
                if (arr[j] > tempMax) {
                    tempMax = arr[j];
                    tempCount++;
                }
            }
            if (count < tempCount) {
                count = tempCount;
                index = i;
            }
        }

        int max = arr[index];
        resultList.add(max);
        for (int i = index+1; i < len; i++) {
            if (max < arr[i]) {
                max = arr[i];
                resultList.add(max);
            }
        }
        return resultList;
    }
}
