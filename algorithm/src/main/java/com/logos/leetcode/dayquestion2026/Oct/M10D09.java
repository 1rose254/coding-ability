package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/9 10:00
 * @version v1.0
 */
public class M10D09 {


    /**
     * 1541. 平衡括号字符串的最少插入次数
     * <a href="https://leetcode.cn/problems/minimum-insertions-to-balance-a-parentheses-string/description/"/>
     */
    class Solution {
        public int minInsertions(String S) {
            char[] s = S.toCharArray();
            int n = s.length;
            int left = 0;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == '(') {
                    left++;
                    continue;
                }
                if (left > 0) {
                    left--;
                } else {
                    ans++;
                }
                if (i < n - 1 && s[i + 1] == ')') {
                    i++;
                } else {
                    ans++;
                }
            }
            return ans + left * 2;
        }
    }

}
