package com.shashank.ps.ds;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Write a function to decode a string.
 * "a(bcd){3}e" -> "abcdbcdbcde"
 * "a(bc(de){4}e){3}f" -> "abcdedededeebcdedededeebcdedededeef"
 */
public class StringDecoding {

    public static void main(String[] args) {
        System.out.println("************* Using Stack ************* ") ;
        System.out.println(getDecodedTextWithStack("a(bc(de){4}e){3}f"));
        System.out.println(getDecodedTextWithStack("a(bcd){3}e"));
        System.out.println(getDecodedTextWithDeque("a(bc(e){0}){3}f"));
        System.out.println("************* Using Deque ************* ") ;
        System.out.println(getDecodedTextWithDeque("a(bc(de){3}e){2}f"));
        System.out.println(getDecodedTextWithDeque("a(bcd){5}e"));
        System.out.println(getDecodedTextWithDeque("a(bc(e){0}){1}f"));
    }

    private static String getDecodedTextWithDeque(String input) {
        Deque<String> dq = new LinkedList<>();

        int i = 0;
        int size = input.length();

        while (i < size) {
            if ((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') ||
                    (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') ||
                    input.charAt(i) == '(' || input.charAt(i) == ')') {
                dq.add(input.substring(i, ++i));
            }
            else if (input.charAt(i) == '{') {
                int indexOfClose = input.indexOf("}", i+1);
                int num = Integer.parseInt(input.substring(i+1, indexOfClose));
                String out;
                StringBuilder sb = new StringBuilder();
                while (!"(".equals(out = dq.removeLast())) {
                    if (!")".equals(out)) {
                        sb.append(out);
                    }
                }
                dq.add(String.valueOf(sb.reverse()).repeat(Math.max(0, num)));
                i = indexOfClose+1;
            }
            else {
                i++;
            }
        }
        StringBuilder res = new StringBuilder();
        while (dq.size() > 0) {
            res.append(dq.removeFirst());
        }
        return res.toString();
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
}
