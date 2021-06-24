package com.shashank.ps.hrPs;

import java.io.*;
import java.util.*;

public class QueensAttackII {

    private static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

        int  count = 0;
        if (n == 1) {
            return 0;
        }

        count += movement(n, k, r_q, c_q, obstacles, 1, 1);
        count += movement(n, k, r_q, c_q, obstacles, 1, -1);
        count += movement(n, k, r_q, c_q, obstacles, -1, 1);
        count += movement(n, k, r_q, c_q, obstacles, -1, -1);
        count += movement(n, k, r_q, c_q, obstacles, 1, 0);
        count += movement(n, k, r_q, c_q, obstacles, 0, 1);
        count += movement(n, k, r_q, c_q, obstacles, -1, 0);
        count += movement(n, k, r_q, c_q, obstacles, 0, -1);

        return count;

    }

    private static int movement(int n, int k, int r_q, int c_q, int[][] obstacles, int dirI, int dirJ) {

        if (r_q+dirI <= 0 || r_q+dirI >n || c_q+dirJ <= 0 || c_q+dirJ >n) {
            return 0;
        }

        for (int i = 0; i < k; i++) {
            if (r_q+dirI == obstacles[i][0] && c_q+dirJ == obstacles[i][1]){
                return 0;
            }
        }

        return 1 + movement(n, k, r_q+dirI, c_q+dirJ, obstacles, dirI, dirJ);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter Cell count and number of roadblocks with a space in a format 'X Y'");
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        System.out.println("Enter Ith and Jth position of queen. Remember the position is from 1 to N and not from 0 to N-1");
        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        if (k > 0) {
            System.out.println("Enter roadblock position in format 'I J' and the next position in a new line");
        }
        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        System.out.println("Attacking Cell count: " +result);
        scanner.close();
    }
}
