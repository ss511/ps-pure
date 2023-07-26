package com.shashank.ps.leetCodeMedium;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example:
 * Input: s = "()"
 * Output: true
 *
 * Input: s = "(]"
 * Output: false
 */
public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("("));
        System.out.println(isValid(")"));
        System.out.println(isValid("){}[]"));
        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("{[()]}"));

    }

    private static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] cs = s.toCharArray();

        if (s.length() == 1) {
            return false;
        }

        for (char c: cs) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if (st.size() > 0) {
                char top = st.peek();
                if ((c == ')' && top == '(') ||
                        (c == '}' && top == '{') ||
                        (c == ']' && top == '[')) {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                if (c == ')' || c == '}' || c == ']') {
                    return false;
                }
            }
        }

        return st.size() == 0;
    }
}
