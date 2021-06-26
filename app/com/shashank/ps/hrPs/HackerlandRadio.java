package com.shashank.ps.hrPs;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Hackerland is a one-dimensional city with houses aligned at integral locations along a road.
 * The Mayor wants to install radio transmitters on the roofs of the city's houses.
 * Each transmitter has a fixed range meaning it can transmit a signal to all houses within that number of units distance away.
 *
 * Given a map of Hackerland and the transmission range, determine the minimum number of transmitters so that every house is within range of at least one transmitter.
 * Each transmitter must be installed on top of an existing house.
 */
class HackerlandRadioResult {

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        int start = Collections.min(x);
        int end = Collections.max(x);

        int count = 0;
        while (start <= end) {
            int j = start+k;
            while(!x.contains(j) && j < end) {
                j--;
            }
            count++;
            start = j+k+1;
            while (!x.contains(start) && start <= end) {
                start++;
            }
        }
        return count;
    }
}

public class HackerlandRadio {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> x = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = HackerlandRadioResult.hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

