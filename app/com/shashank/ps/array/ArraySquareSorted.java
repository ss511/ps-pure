package com.shashank.ps.array;

import java.util.Arrays;

/**
 * Given a sorted array, square it and print again in sorted order.
 * This solution executes in O(n) time and takes O(n) space.
 * Rather than performing a sorting after square which makes the solution O(nlogn),
 * It simply breaks, squares and merges back.
 * But trade-off is that it uses linear space rather than constant.
 */
public class ArraySquareSorted {

    public static void main(String[] args){
        int[] res = sortedSquares(new int[]{-8, -5, -3, -1, 2, 9, 12, 15});
        Arrays.stream(res).forEach(i -> {
            System.out.print(i + " ");
        });
    }

    public static int[] sortedSquares(int[] nums) {

        int k = 0;
        int len = nums.length;
        for (k = 0; k < len; k++) {
            if (nums[k] >= 0) {
                break;
            }
        }
        int[] temp = new int[len];
        int i = k-1;
        int j = k;
        int index = 0;

        while(i >= 0 && j < len) {
            if (nums[i]*nums[i] < nums[j]*nums[j]) {
                temp[index] = nums[i]*nums[i];
                index++;
                i--;
            } else {
                temp[index] = nums[j]*nums[j];
                index++;
                j++;
            }
        }

        while (i >= 0) {
            temp[index] = nums[i]*nums[i];
            i--;
            index++;
        }

        while (j < len) {
            temp[index] = nums[j]*nums[j];
            index++;
            j++;
        }

        return temp;
    }
}
