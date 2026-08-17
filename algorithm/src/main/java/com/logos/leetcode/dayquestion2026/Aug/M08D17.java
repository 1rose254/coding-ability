package com.logos.leetcode.dayquestion2026.Aug;

/**
 * @author logos
 * date 2026/8/17 19:37
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D17 {

    /**
     * 1563. 石子游戏 V
     * <a href="https://leetcode.cn/problems/stone-game-v/description/"/>
     */

    class Solution {
        public int stoneGameV(int[] stoneValue) {
            int n = stoneValue.length;
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + stoneValue[i];
            }
            int[][] dp = new int[n][n + 1];
            return dfs(0, n, sum, dp);
        }

        private int dfs(int i, int j, int[] sum, int[][] dp) {
            if (j - i == 1) {
                return 0;
            }
            if (dp[i][j] > 0) {
                return dp[i][j];
            }
            int res = 0;
            for (int k = i + 1; k < j; k++) {
                int sumL = sum[k] - sum[i];
                int sumR = sum[j] - sum[k];
                int score;
                if (sumL < sumR) {
                    score = dfs(i, k, sum, dp) + sumL;
                } else if (sumL > sumR) {
                    score = dfs(k, j, sum, dp) + sumR;
                } else {
                    score = Math.max(dfs(i, k, sum, dp), dfs(k, j, sum, dp)) + sumL;
                }
                res = Math.max(res, score);
            }
            dp[i][j] = res;
            return res;
        }
    }

}
