package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/5 09:53
 * @version v1.0
 */
public class M10D05 {

    /**
     * 856. 括号的分数
     * <a href="https://leetcode.cn/problems/score-of-parentheses/description/"/>
     */

    class Solution {
        public int scoreOfParentheses(String S) {
            char[] s = S.toCharArray();
            int depth = 0;
            int ans = 0;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == '(') {
                    depth++;
                } else {
                    depth--;
                    if (s[i - 1] == '(') {
                        ans += 1 << depth;
                    }
                }
            }
            return ans;
        }
    }

}
