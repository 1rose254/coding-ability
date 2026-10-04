package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/4 09:40
 * @version v1.0
 */
public class M10D04 {

    /**
     * 678. 有效的括号字符串
     * <a href="https://leetcode.cn/problems/valid-parenthesis-string/description/"/>
     */

    class Solution {
        public boolean checkValidString(String s) {
            int mn = 0;
            int mx = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    mn++;
                    mx++;
                } else if (ch == ')') {
                    mn--;
                    mx--;
                    if (mx < 0) {
                        return false;
                    }
                } else {
                    mn--;
                    mx++;
                }
                mn = Math.max(mn, 0);
            }
            return mn == 0;
        }
    }

}
