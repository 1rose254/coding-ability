package com.logos.leetcode.hot100.multi_dp;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/3/16 20:29
 * @version v1.0
 * @Package com.logos.leetcode.hot100.multi_dp
 */
public class Q05 {

    /**
     * 72. 编辑距离
     */

    class Solution {

        private char[] s, t;

        private int[][] dp;

        public int minDistance(String word1, String word2) {
            s = word1.toCharArray();
            t = word2.toCharArray();
            int n = s.length;
            int m = t.length;
            dp = new int[n][m];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return dfs(n - 1, m - 1);
        }

        private int dfs(int i, int j) {
            if (i < 0) {
                return j + 1;
            }
            if (j < 0) {
                return i + 1;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            if (s[i] == t[j]) {
                return dp[i][j] = dfs(i - 1, j - 1);
            }
            return dp[i][j] = Math.min(Math.min(dfs(i - 1, j), dfs(i, j - 1)), dfs(i - 1, j - 1)) + 1;
        }
    }

}
