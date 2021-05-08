package com.shashank.ps.array;

import java.util.Scanner;

/**
 * Finds the SubArray which will sum up to a given input. Array could be un-sorted.
 */
public class SubArraySum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Array Size: ");
        int size = scanner.nextInt();

        System.out.println("Input Array:");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Input Sum Value:");
        int sum = scanner.nextInt();

        scanner.close();

        findSubArrayIndex(size, arr, sum);
    }

    private static void findSubArrayIndex(int size, int[] arr, int sum) {

        if (size == 0) {
            System.out.println("SubArray not found");
            System.exit(0);
        }

        int lowerIndex = 0;
        int upperIndex = 0;
        int subArraySum = 0;

        for (int i = 0; i < size; i++) {
            subArraySum += arr[i];
            if (subArraySum < sum) {
                upperIndex++;
            } else if (subArraySum == sum) {
                System.out.println("The SubArray is found starting at index: " + lowerIndex + " and ending at index: " + upperIndex);
                System.exit(0);
            } else {
                lowerIndex++;
                i = lowerIndex-1;
                upperIndex = lowerIndex;
                subArraySum = 0;
            }
        }
        System.out.println("SubArray not found");
    }
}
