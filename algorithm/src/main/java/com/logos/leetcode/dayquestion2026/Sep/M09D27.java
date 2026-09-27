package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/27 09:22
 * @version v1.0
 */
public class M09D27 {

    /**
     * 1190. 反转每对括号间的子串
     * <a href="https://leetcode.cn/problems/reverse-substrings-between-each-pair-of-parentheses/description/"/>
     */

    class Solution {
        private int i = 0;

        public String reverseParentheses(String S) {
            char[] s = S.toCharArray();
            return f(s).toString();
        }

        private StringBuilder f(char[] s) {
            StringBuilder res = new StringBuilder();
            while (i < s.length) {
                char ch = s[i];
                i++;
                if (ch == ')') {
                    return res.reverse();
                }
                if (ch == '(') {
                    res.append(f(s));
                } else {
                    res.append(ch);
                }
            }
            return res;
        }
    }

}
