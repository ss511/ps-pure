package com.shashank.ps.array;

import java.util.Arrays;

/**
 * Given an array of packets, the value represents number of chocolates stored in each packets.
 * Given another input studentCount, which tells the number of student which is always less the number of packets.
 * Each student will get only one packet.
 * Distribute packet such that the difference between the number of chocolates in the packet with maximum chocolates and packet with minimum chocolates given to the students is minimum.
 */
public class ChocolateDistribution {

    public static void main (String[] args) {
        int[] packets = {3, 4, 1, 9, 56, 7, 9, 12};
        int studentCount = 5;

        System.out.println("Difference between max packet and min packet is: " + getDiff(packets, studentCount));
    }

    private static int getDiff(int[] packets, int studentCount) {
        Arrays.sort(packets);

        int minDiff = Integer.MAX_VALUE;
        int packetCount = packets.length;

        for (int i = 0; i <= packetCount-studentCount; i++) {
            int packetDiff = packets[i+studentCount-1] - packets[i];
            minDiff = Math.min(packetDiff, minDiff);
        }
        return minDiff;
    }
}
