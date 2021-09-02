package com.shashank.ps.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given two sorted arrays, such that the arrays may have some common elements.
 * Find the sum of the maximum sum path to reach from the beginning of any array to end of, any of the two arrays.
 * We can switch from one array to another array only at common elements
 */
public class MaxSumPath {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input size of arr1");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter array elements");
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Input size of arr2");
        int m = Integer.parseInt(br.readLine());
        System.out.println("Enter array elements");
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println("Max Sum is : " + maxSumPath(arr1, arr2, n, m));

    }

    private static int maxSumPath(int[] arr1, int[] arr2, int n, int m) {

        int sum1 = 0;
        int sum2 = 0;

        int smaller = Math.min(n, m);

        for(int i =0; i < smaller; i++) {
            sum1 = sum1+arr1[i];
            sum2 = sum2+arr2[i];

            if(arr1[i] == arr2[i]) {
                int larger = Math.max(sum1, sum2);
                sum1 = larger;
                sum2 = larger;
            }
        }

        if (n < m) {
            for (int i = n; i < m; i++) {
                sum2+=arr2[i];
            }
        } else if (n > m){
            for (int i = m; i < n; i++) {
                sum1+=arr1[i];
            }
        }

        return Math.max(sum1, sum2);
    }
}
