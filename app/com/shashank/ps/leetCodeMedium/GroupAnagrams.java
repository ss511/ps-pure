package com.shashank.ps.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * Example:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {"a", "b"};
        System.out.println(groupAnagrams(strs1));
        System.out.println(groupAnagrams(strs2));
    }g

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagram = new HashMap<>();
        for (String str: strs) {
            String sortedStr = sortString(str);
            List<String> anagramCol = anagram.getOrDefault(sortedStr, new ArrayList<>());
            anagramCol.add(str);
            anagram.put(sortedStr, anagramCol);
        }
        return new ArrayList<>(anagram.values());
    }

    private static String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
