package com.shashank.ps.sortings;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Program to find Kth largest item of an array. Uses max heap using Priority Queue.
 * K here starts from 0 to n-1, 0 meaning the largest item in the array.
 */
public class KthLargestItem {
    public static void main(String[] args) {
        int[] items = {3, 2, 4, 1, 5, 6, 7, 6};
        int k = 3;
        System.out.println("Kth Largest Item is: " + getKthLargestItem(items, k));
    }

    private static int getKthLargestItem(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toCollection(() -> new PriorityQueue<Integer>(Collections.reverseOrder())));
        int i = 0;
        if (k > maxHeap.size()) {
            return -1;
        }
        while (i < k) {
            maxHeap.remove();
            i++;
        }
        return maxHeap.remove();
    }
}
