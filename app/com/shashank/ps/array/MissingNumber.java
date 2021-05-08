package com.shashank.ps.array;

/**
 * Find the missing number where each array element is a distinct value between 1 to N
 */
public class MissingNumber {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11};

        int size = arr.length;

        int last = arr[size-1];
        int total = last*(last+1)/2;

        int arrSum = 0;
        for (int i = 0; i < size; i++) {
            arrSum += arr[i];
        }

        System.out.println("Missing Number is: " + (total-arrSum));
    }
}
