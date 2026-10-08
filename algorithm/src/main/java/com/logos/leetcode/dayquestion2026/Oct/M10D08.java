package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/8 10:00
 * @version v1.0
 */
public class M10D08 {

    /**
     * 1021. 删除最外层的括号
     * <a href="https://leetcode.cn/problems/remove-outermost-parentheses/description/"/>
     */

    class Solution {
        public String removeOuterParentheses(String S) {
            char[] s = S.toCharArray();
            int size = 0;
            int depth = 0;
            for (char ch : s) {
                if (ch == '(') {
                    if (depth > 0) {
                        s[size++] = ch;
                    }
                    depth++;
                } else {
                    depth--;
                    if (depth > 0) {
                        s[size++] = ch;
                    }
                }
            }
            return new String(s, 0, size);
        }
    }

}
