package com.shashank.ps.leetCodeMedium;

import java.util.HashMap;
import java.util.Map;

/**
 * Program to find the longest substring in a string with non-repeating characters.
 * Example:
 * bbtablud -> 6 (tablud)
 */
public class LongestSubStringNonRepeatingChar {

    public static void main(String[] args) {
        String s = "bbtablud";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> sw = new HashMap<>();

        int output = 0;
        int temp = 0;
        int pos = 1;
        for (Character c: s.toCharArray()) {
            if (sw.containsKey(c) && pos-temp <= sw.get(c) ) {
                output = Math.max(temp, output);
                int occ = sw.get(c);
                temp = pos-occ-1;
            }
            sw.put(c, pos++);
            temp++;
        }
        output = Math.max(output, temp);
        return output;
    }
}
