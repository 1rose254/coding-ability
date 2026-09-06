package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @author logos
 * date 2026/9/6 10:28
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Sep
 */
public class M09D06 {

    /**
     * 115. 不同的子序列
     * <a href="https://leetcode.cn/problems/distinct-subsequences/description/"/>
     */

    class Solution {
        public int numDistinct(String str, String target) {
            int n = str.length();
            int m = target.length();
            char[] s = str.toCharArray();
            char[] t = target.toCharArray();
            int[] dp = new int[m + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = m; j >= 1; j--) {
                    if (s[i - 1] == t[j - 1]) {
                        dp[j] += dp[j - 1];
                    }
                }
            }
            return dp[m];
        }
    }

}
