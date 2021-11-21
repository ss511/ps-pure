package com.shashank.ps.hrPs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This program finds out the combination of letter given phone number key as input.
 * In an old phone, key 2 contains a,b,c , key 3 contains d,e,f, and so on.
 */
public class PhoneLetterCombination {

    public static void main(String[] args) {
        String digits = "34";
        List<String> resp = letterCombinations(digits);
        System.out.println(Arrays.toString(resp.toArray()));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Integer, List<Character>> charMap = new HashMap<>();

        charMap.put(0, new ArrayList<>());
        charMap.put(1, new ArrayList<>());
        charMap.put(2, Arrays.asList('a', 'b', 'c'));
        charMap.put(3, Arrays.asList('d', 'e', 'f'));
        charMap.put(4, Arrays.asList('g', 'h', 'i'));
        charMap.put(5, Arrays.asList('j', 'k', 'l'));
        charMap.put(6, Arrays.asList('m', 'n', 'o'));
        charMap.put(7, Arrays.asList('p', 'q', 'r', 's'));
        charMap.put(8, Arrays.asList('t', 'u', 'v'));
        charMap.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        int len = digits.length();
        int pos = 0;
        if (len == pos) {
            return res;
        }

        letterCombinationsUtil(pos, len, digits, charMap, res, new StringBuilder());

        return res;
    }

    private static void letterCombinationsUtil(int pos, int len, String digits,
                                               Map<Integer, List<Character>> charMap,
                                               List<String> res, StringBuilder sb) {

        if (pos == len) {
            res.add(sb.toString());
        }
        else {
            int digit = Character.getNumericValue(digits.charAt(pos));
            int i = 0;
            while (i < charMap.get(digit).size()) {
                letterCombinationsUtil(pos+1, len, digits, charMap, res,
                        new StringBuilder(sb).append(charMap.get(digit).get(i)));
                i++;
            }
        }
    }
}
