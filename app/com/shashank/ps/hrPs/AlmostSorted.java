package com.shashank.ps.hrPs;

import java.io.*;
import java.util.*;

import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Given an array of integers, determine whether the array can be sorted in ascending order using only one of the following operations one time.
 *
 * 1. Swap two elements.
 * 2. Reverse one sub-segment.
 */
class ResultAlmostSorted {

    public static void almostSorted(List<Integer> arr) {

        List<Integer> temp = new ArrayList<>(arr);
        Collections.sort(temp);

        List<Integer> index = new ArrayList<>();

        for (int i=0; i<arr.size(); i++) {
            if (!arr.get(i).equals(temp.get(i))) {
                index.add(i+1);
            }
        }
        if (index.size() == 0) {
            System.out.println("yes");
        }
        else if (index.size() == 2) {
            System.out.println("yes");
            System.out.println("swap " + index.get(0) + " " + index.get(1));
        }
        else {
            boolean flag = true;
            int i = 0;
            int j = index.size()-1;
            while(i < index.size()) {
                int x = (index.get(i))-1;
                int y = (index.get(j))-1;
                if (!arr.get(x).equals(temp.get(y))) {
                    flag = false;
                    break;
                }
                i++;
                j--;
            }
            if (flag) {
                System.out.println("yes");
                System.out.println("reverse " + index.get(0) + " " + index.get(index.size()-1));
            } else {
                System.out.println("no");
            }
        }
    }

}

public class AlmostSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        ResultAlmostSorted.almostSorted(arr);

        bufferedReader.close();
    }
}
