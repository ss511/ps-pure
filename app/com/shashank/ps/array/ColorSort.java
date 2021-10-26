package com.shashank.ps.array;

import java.util.Arrays;

/**
 * This program sorts an array of integers denoting colors 0-red, 1-white, 2-blue.
 * O(n) time complexity using Counting Sort.
 */
public class ColorSort {

    public static void main(String[] args) {
        int[] colors = {2, 0, 1, 0, 1, 0, 2, 0, 1};
        System.out.println("Colors before sorting: ");
        System.out.println(Arrays.toString(colors));
        sortedColors(colors);
        System.out.println("Colors before sorting: ");
        System.out.println(Arrays.toString(colors));
    }

    private static void sortedColors(int[] colors) {
        int[] count = new int[3];
        for(int i: colors) {
            count[i] += 1;
        }

        int i = 0;
        int j = 0;
        while (i < colors.length) {
            if (count[j] != 0) {
                colors[i] = j;
                count[j]--;
                i++;
            } else {
                j++;
            }
        }
    }
}
