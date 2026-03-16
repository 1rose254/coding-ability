package com.logos.leetcode.hot100.multi_dp;

/**
 * @author logos
 * date 2026/3/16 20:21
 * @version v1.0
 * @Package com.logos.leetcode.hot100.multi_dp
 */
public class Q04 {

    /**
     * 1143. 最长公共子序列
     */

    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] s1, s2;
            if (text1.length() > text2.length()) {
                s1 = text1.toCharArray();
                s2 = text2.toCharArray();
            } else {
                s1 = text2.toCharArray();
                s2 = text1.toCharArray();
            }
            int n = s1.length;
            int m = s2.length;
            int[] dp = new int[m + 1];
            for (int len1 = 1; len1 <= n; len1++) {
                int leftup = 0;
                int backup;
                for (int len2 = 1; len2 <= m; len2++) {
                    backup = dp[len2];
                    if (s1[len1 - 1] == s2[len2 - 1]) {
                        dp[len2] = leftup + 1;
                    } else {
                        dp[len2] = Math.max(dp[len2], dp[len2 - 1]);
                    }
                    leftup = backup;
                }
            }
            return dp[m];
        }
    }

}
