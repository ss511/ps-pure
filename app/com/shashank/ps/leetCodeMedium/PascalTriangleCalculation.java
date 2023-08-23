package com.shashank.ps.leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example, If Input = 5
 *          1
 *        1   1
 *      1   2   1
 *    1   3   3   1
 *  1   4   6   4   1
 */
public class PascalTriangleCalculation {
    public static void main(String[] args) {
        System.out.println(getPascalTriangle(5));
        System.out.println("----------------");
        System.out.println(getPascalTriangle(1));
        System.out.println("----------------");
        System.out.println(getPascalTriangle(10));
        System.out.println("----------------");
        System.out.println(getPascalTriangle(8));
    }

    private static List<List<Integer>> getPascalTriangle(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> aux = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    aux.add(1);
                } else {
                    aux.add(pascal.get(pascal.size()-1).get(j-1) + pascal.get(pascal.size()-1).get(j));
                }
            }
            pascal.add(new ArrayList<>(aux));
        }
        return pascal;
    }
}
