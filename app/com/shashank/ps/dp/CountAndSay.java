package com.shashank.ps.dp;

/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula.
 *
 * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit.
 * Then for each substring, say the number of digits, then say the digit.
 * Finally, concatenate every said digit.
 *
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 *
 */
public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(4));
        System.out.println(countAndSay.countAndSay(5));
    }

    private String countAndSay(int n) {
        if (n == 1) {
            return Integer.toString(n);
        }

        String response = countAndSay(n-1);

        int tempCount = 1;
        char[] rc = response.toCharArray();
        int rcLen = rc.length;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < rcLen; i++) {

            if (rc[i] == rc[i-1]) {
                tempCount++;
            } else {
                sb.append(tempCount).append(rc[i-1]);
                tempCount = 1;
            }
        }
        sb.append(tempCount).append(rc[rcLen-1]);
        return sb.toString();
    }
}
