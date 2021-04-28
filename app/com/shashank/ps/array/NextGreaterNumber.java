package com.shashank.ps.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the next greater number of items of an array, from the array. -1 will be returned if no greater number.
 *
 * Have used queue to solve this problem, rather than stack.
 */
public class NextGreaterNumber {

    public static void main(String[] args) {
        int[] arr1 = {1,5,2,36,98,24,45};
        int[] arr2 = {4,5,2,25};
        int[] arr3 = {13,7,6,12};
        int[] arr4 = {1,2,3,4};
        int[] arr5 = {4,3,2,1};

        int[] result1 = nextGreaterNumber(arr1);
        int[] result2 = nextGreaterNumber(arr2);
        int[] result3 = nextGreaterNumber(arr3);
        int[] result4 = nextGreaterNumber(arr4);
        int[] result5 = nextGreaterNumber(arr5);

        System.out.println("Result 1");
        for(int item: result1) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("Result 2");
        for(int item: result2) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("Result 3");
        for(int item: result3) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("Result 4");
        for(int item: result4) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("Result 5");
        for(int item: result5) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    static int[] nextGreaterNumber(int[] arr) {

        int size = arr.length;
        if (size == 0) {
            return arr;
        }
        int[] nextGreaterNumbers = new int[size];

        for (int i = 0; i < size; i++) {
            nextGreaterNumbers[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(arr[0]);
        int i = 1;
        int j = 0;
        boolean repeatFlag = false;
        boolean reExecution = false;
        while (i < size) {
            if (!queue.isEmpty() && arr[i] > queue.peek()) {
                nextGreaterNumbers[j] = arr[i];
                queue.poll();
                j++;
                if (!repeatFlag) {
                    queue.add(arr[i]);
                    repeatFlag = true;
                }
            } else {
                if (!repeatFlag) {
                    queue.add(arr[i]);
                }
                else if (!reExecution){
                    repeatFlag = false;
                }
                i++;
            }
            if (i == size-1 && (!queue.isEmpty() && arr[i] < queue.peek())) {
                queue.poll();
                i = ++j;
                repeatFlag = true;
                reExecution = true;
            }
        }
        return nextGreaterNumbers;
    }
}
