package com.logos.leetcode.hot100.dp;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/3/11 16:55
 * @version v1.0
 * @Package com.logos.leetcode.hot100.dp
 */
public class Q04 {

    /**
     * 279. 完全平方数
     */

    class Solution {
        private static final int[][] dp = new int[101][10001];

        static {
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
        }

        private static int dfs(int i, int j) {
            if (i == 0) {
                return j == 0 ? 0 : Integer.MAX_VALUE;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            if (j < i * i) {
                return dp[i][j] = dfs(i - 1, j);
            }
            return dp[i][j] = Math.min(dfs(i - 1, j), dfs(i, j - i * i) + 1);
        }

        public int numSquares(int n) {
            return dfs((int) Math.sqrt(n), n);
        }
    }

}
