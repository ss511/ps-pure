package com.shashank.ps.leetCodeMedium;

/**
 * Program to find longest palindromic substring in a string.
 * babad -> bab or aba
 * babab -> babab
 */
public class LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("babab"));
        System.out.println(longestPalindrome("abbd"));
        System.out.println(longestPalindrome("c"));
    }

    private static String longestPalindrome(String s) {
        int sSize = s.length();
        if (sSize == 0 || sSize == 1) {
            return s;
        }
        int si = 0;
        int ei = 0;

        for (int i = 0; i < sSize; i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);

            if (len > ei-si) {
                si = i - (len-1)/2;
                ei = i + len/2;
            }
        }
        return s.substring(si, ei+1);
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }
}
