package com.shashank.ps.array;

/**
 * Program to find max profit while buying and selling a stock. The transaction can be performed multiple times, but in order.
 * If bought once the next step will be to sell only, and then repeat the process.
 * The input array contains the value of stock on given days.
 */
public class BuySellStock2 {

    public static void main(String[] args) {
        int[] stock = {3, 4, 8, 2, 3, 5, 3, 16};

        System.out.println("Max Profit is : " + getMaxProfit(stock));

    }

    public static int getMaxProfit(int[] stock) {

        int tradingWindow = stock.length;

        int minVal = stock[0];
        int profit = 0;
        int localMax = 0;

        for (int i = 1; i < tradingWindow; i++) {

            if (stock[i] > stock[i-1]) {
                localMax = Math.max(localMax, stock[i]-minVal);
            } else {
                minVal = stock[i];
                profit += localMax;
                localMax = 0;
            }
        }
        profit += localMax;

        return profit;
    }
}
