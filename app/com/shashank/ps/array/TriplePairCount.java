package com.shashank.ps.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Count the number of distinct triplet pair in three arrays, where a <=b and b >= c,
 * where a belongs to arr1, b to arr2, and c to arr3.
 */
public class TriplePairCount {

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 3};
        int[] arr2 = {1, 3, 5};
        int[] arr3 = {1, 2, 3};
        System.out.print("Count of triplet pairs is: " + countTripletPair(arr1, arr2, arr3));
    }

    private static long countTripletPair(int[] a, int[] b, int[] c) {
        List<Integer> al = getSortedDistinctList(a);
        List<Integer> bl = getSortedDistinctList(b);
        List<Integer> cl = getSortedDistinctList(c);

        int ai = 0;
        int bi = 0;
        int ci = 0;

        int bSize = bl.size();
        long ans = 0;

        while (bi < bSize) {
            while (ai < al.size() && al.get(ai) <= bl.get(bi)) {
                ai++;
            }
            while (ci < cl.size() && cl.get(ci) <= bl.get(bi)) {
                ci++;
            }
            ans += (long) ai *ci;
            bi ++;
        }
        return ans;
    }

    private static List<Integer> getSortedDistinctList(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
