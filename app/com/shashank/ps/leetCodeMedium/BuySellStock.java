package com.shashank.ps.leetCodeMedium;

import java.util.Arrays;

public class BuySellStock {

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {1,2,3,4,5};
        int[] prices3 = {7,6,4,3,1};

        System.out.println(withSingleTransaction(prices1));
        System.out.println(withSingleTransaction(prices2));
        System.out.println(withSingleTransaction(prices3));

        System.out.println("-------------------------------------------------");

        System.out.println(withInfiniteTransactions(prices1));
        System.out.println(withInfiniteTransactions(prices2));
        System.out.println(withInfiniteTransactions(prices3));

    }

    /**
     * Solved using DP. Can also be solved without it
     * Example:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     *
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     *
     * @param prices - array containing daily stock prices.
     * @return maxProfit
     */
    private static int withSingleTransaction(int[] prices) {
        int len = prices.length;
        int profit = 0;

        if (len <= 1) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = 0;
        int temp = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] < prices[i-1]) {
                dp[i] = dp[i-1];
                if (prices[i] < prices[temp]) {
                    temp = i;
                }
            } else {
                dp[i] = Math.max(dp[i-1], (prices[i] - prices[temp]));
            }
        }

        return dp[len-1];
    }

    /**
     * Solved without using DP.
     *
     * Example:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Total profit is 4 + 3 = 7.
     *
     * Input: prices = [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Total profit is 4.
     *
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
     *
     * @param prices - array containing daily stock prices.
     * @return - totalProfit
     */
    private static int withInfiniteTransactions(int[] prices) {
        int sell = 0;
        int buy = 0;
        int total = 0;

        int len = prices.length;
        if (len <= 1) {
            return total;
        }

        for (int i = 1; i < len; i++) {
            if (prices[i] >= prices[i-1]) {
                sell++;
            } else {
                total += prices[sell] - prices[buy];
                sell = buy = i;
            }
        }

        total += prices[sell] - prices[buy];
        return total;
    }
}
