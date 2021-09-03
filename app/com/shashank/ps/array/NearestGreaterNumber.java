package com.shashank.ps.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an integer find the next greater permutation of this. Ex -
 * 169 -> 196 -> 619 -> 691 -> 916 -> 961
 */
public class NearestGreaterNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> greaterNumbers = getNextGreaterNumbers(n);
        if (greaterNumbers.size() == 0) {
            System.out.println("The input is number is the greatest among its permutation.");
            System.exit(0);
        }
        greaterNumbers.forEach(i -> System.out.print(i + "  "));
        br.close();
    }

    private static List<Integer> getNextGreaterNumbers(int n) {
        LinkedList<Integer> numbers = new LinkedList<>();
        while (n > 0) {
            numbers.push(n%10);
            n = n/10;
        }
        List<Integer> result = new ArrayList<>();
        int size = numbers.size();
        if (size == 1) {
            return List.of(n);
        }

        do {
            int i;
            for (i = size-1; i > 0; i--) {
                if (numbers.get(i) > numbers.get(i-1)) {
                    break;
                }
            }
            if (i == 0) {
                break;
            } else {
                int x = numbers.get(i - 1);
                int min = i;

                for (int k = i + 1; k < size; k++) {
                    if (numbers.get(k) > x && numbers.get(k) < numbers.get(min)) {
                        min = k;
                    }
                }

                int temp = numbers.get(i-1);
                numbers.set(i-1, numbers.get(min));
                numbers.set(min, temp);

                Collections.sort(numbers.subList(i, size));
            }
            int total = 0;
            for (Integer num : numbers) {
                total = 10 * total + num;
            }

            result.add(total);
        } while (!numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).equals(numbers));

        return result;
    }
}
