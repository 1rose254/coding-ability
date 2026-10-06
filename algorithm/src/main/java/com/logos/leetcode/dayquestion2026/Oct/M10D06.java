package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/6 09:53
 * @version v1.0
 */
public class M10D06 {

    /**
     * 921. 使括号有效的最少添加
     * <a href="https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/description/"/>
     */

    class Solution {
        public int minAddToMakeValid(String s) {
            int left = 0;
            int ans = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    left++;
                } else if (left > 0) {
                    left--;
                } else {
                    ans++;
                }
            }
            return ans + left;
        }
    }

}
