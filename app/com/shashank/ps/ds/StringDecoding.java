package com.shashank.ps.ds;

import java.util.Stack;

/**
 * Write a function to decode a string.
 * "a(bcd){3}e" -> "abcdbcdbcde"
 * "a(bc(de){4}e){3}f" -> "abcdedededeebcdedededeebcdedededeef"
 */
public class StringDecoding {

    public static void main(String[] args) {
        System.out.println(getDecodedTextWithStack("a(bc(de){4}e){3}f"));
        System.out.println(getDecodedTextWithStack("a(bcd){3}e"));
        System.out.println(getDecodedTextWithStack("a(bc(e){0}){3}f"));
    }

    private static String getDecodedTextWithStack(String input) {

        Stack<String> st = new Stack<>();

        int i = 0;
        int size = input.length();

        while (i < size) {
            if ((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') ||
                    (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') ||
                    input.charAt(i) == '(' || input.charAt(i) == ')') {
                st.push(input.substring(i, ++i));
            }
            else if (input.charAt(i) == '{') {
                int indexOfClose = input.indexOf("}", i+1);
                int num = Integer.parseInt(input.substring(i+1, indexOfClose));
                String out = st.pop();
                StringBuilder sb = new StringBuilder();
                while (!"(".equals(out)) {
                    if (!")".equals(out)) {
                        sb.append(out);
                    }
                    out = st.pop();
                }
                st.push(String.valueOf(sb).repeat(Math.max(0, num)));
                i = indexOfClose+1;
            }
            else {
                i++;
            }
        }
        StringBuilder res = new StringBuilder();
        while (!st.empty()) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }

//    public static String getDecodedText(String input) {
//
//        Stack<Character> chars = new Stack<>();
//        Stack<Integer> nums = new Stack<>();
//
//        int i = 0;
//
//        StringBuilder sb = new StringBuilder();
//
//        char[] letters = input.toCharArray();
//        while(i < letters.length) {
//
//            if (letters[i] == '{') {
//                i++;
//                int num = 0;
//                while (letters[i] != '}') {
//                    num = num * 10 + letters[i] - '0';
//                    i++;
//                }
//                nums.push(num);
//            } else {
//                chars.push(letters[i]);
//            }
//            i++;
//        }
//
//        while (!nums.isEmpty()) {
//            int n = nums.pop();
//            char ch = chars.pop();
//            while (ch != ')') {
//                sb.append(ch);
//                ch = chars.pop();
//            }
//            StringBuilder temp = new StringBuilder();
//            int repeat = 0;
//            while (repeat >= 0) {
//                Character c = chars.pop();
//                if (c == ')') {
//                    repeat++;
//                } else if (c == '(') {
//                    repeat--;
//                }
//                if (repeat >= 0) {
//                    temp.append(c);
//                }
//            }
//            sb.append(String.valueOf(temp).repeat(Math.max(0, n)));
//            String newSet = sb.reverse().toString();
//            for(char c1: newSet.toCharArray()) {
//                chars.push(c1);
//            }
//            sb = new StringBuilder();
//        }
//
//        StringBuilder result = new StringBuilder();
//
//        while(!chars.isEmpty()) {
//            result.append(chars.pop());
//        }
//        return result.reverse().toString();
//    }

}
