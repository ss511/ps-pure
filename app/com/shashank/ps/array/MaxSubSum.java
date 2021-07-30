package com.shashank.ps.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Program to find max sum sub array and max sum sub-sequence in an array with both negative and positive integers.
 */
public class MaxSubSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                List<Integer> result = maxSubarray(arr);

                for (Integer res: result) {
                    System.out.println(res + "\t");
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    private static List<Integer> maxSubarray(List<Integer> arr) {

        List<Integer> result = new ArrayList<>();

        result.add(getMaxSubArraySum(arr));
        result.add(getMaxSubSequence(arr));

        return result;
    }

    private static int getMaxSubArraySum(List<Integer> arr) {
        int currMax = arr.get(0);
        int totalMax = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            currMax = Math.max(arr.get(i), currMax+arr.get(i));
            totalMax = Math.max(totalMax, currMax);
        }
        return totalMax;
    }

    private static int getMaxSubSequence(List<Integer> arr) {
        int subSeqSum = 0;
        int largest = Integer.MIN_VALUE;

        for (Integer n : arr) {
            if (n > 0) {
                subSeqSum += n;
            }
            if (n > largest) {
                largest = n;
            }
        }
        return largest < 0 ? largest: subSeqSum;
    }

}
