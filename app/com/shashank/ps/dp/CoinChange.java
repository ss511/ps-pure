package com.shashank.ps.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Coin change problem.
 * Given a set of coins and infinite supply of each coin and a give an input n.
 * Find the number of ways the coins can be added up to the sum n.
 *
 * Uses bottom-up tabulation approach of DP.
 */
public class CoinChange {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int[] c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long ways = getWays(n, c);

        System.out.println("Number of ways: " + ways);

        long waysRecursive = getWaysRecursive(n, c.length, c);

        System.out.println("Number of ways using recursive method: " + waysRecursive);

        bufferedReader.close();
    }

    private static long getWays(int n, int[] c) {
        long[] table=new long[n+1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for (int k : c) {
            for (int j = k; j <= n; j++) {
                table[j] += table[j - k];
            }
        }
        return table[n];
    }

    private static long getWaysRecursive(int n, int m, int[] c) {

        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }

        if (m <= 0 && n >= 1) {
            return 0;
        }

        return getWaysRecursive(n, m-1, c) + getWaysRecursive(n-c[m-1], m, c);

    }
}
