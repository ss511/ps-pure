package com.shashank.ps.dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Program to find out the number of tables required given a set of table capacity and the desired seat.
 * Makes use of binary tree concept, starting from the total seat and largest table and working the way downward.
 * Uses queue to solve the problem, as with how the binary tree will be populated given a set of numbers.
 */
public class TableBooking {

    public static void main(String[] args) {
        int[] tableChoice = {2,3,4,6,8};
        int seats = 18;
        Map<Integer, Integer> seatMap = getTables(tableChoice, seats);
        for(Map.Entry<Integer, Integer> entry : seatMap.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(entry.getKey() + " -- " + entry.getValue());
            }
        }
    }

    private static Map<Integer, Integer> getTables(int[] tableChoice, int seats) {
        Map<Integer, Integer> seatMap = new HashMap<>();
        int size = tableChoice.length;
        for (int k : tableChoice) {
            seatMap.put(k, 0);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(seats);

        int i = size-1;

        while (!q.isEmpty() && i >= 0) {
            int curr = q.peek()-tableChoice[i];
            if (curr >= tableChoice[i] || curr >= tableChoice[0] || curr == 0) {
                seatMap.put(tableChoice[i], seatMap.get(tableChoice[i])+1);
                q.poll();
                q.add(curr);
                seats = seats - tableChoice[i];
                i = curr < tableChoice[i] ? --i : i;
            } else {
                i--;
            }
        }
        while (seats > 0) {
            seatMap.put(tableChoice[0], seatMap.get(tableChoice[0])+1);
            seats = seats-tableChoice[0];
        }

        return seatMap;
    }
}
