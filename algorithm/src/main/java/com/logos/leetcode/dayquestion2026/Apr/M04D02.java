package com.logos.leetcode.dayquestion2026.Apr;

/**
 * @author logos
 * date 2026/4/2 10:07
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D02 {

    /**
     * 3418. 机器人可以获得的最大金币数
     * <a href="https://leetcode.cn/problems/maximum-amount-of-money-robot-can-earn/description/"/>
     */

    class Solution {
        public int maximumAmount(int[][] coins) {
            return solve(coins, 2);
        }

        public int solve(int[][] coins, int r) {
            int m = coins.length;
            int n = coins[0].length;
            int[][][] dp = new int[m][n][r + 1];
            dp[0][0][0] = coins[0][0];
            int startValue = Math.max(coins[0][0], 0);
            for (int k = 1; k <= r; k++) {
                dp[0][0][k] = startValue;
            }
            for (int j = 1; j < n; j++) {
                dp[0][j][0] = dp[0][j - 1][0] + coins[0][j];
                for (int k = 1; k <= r; k++) {
                    dp[0][j][k] = Math.max(dp[0][j - 1][k] + coins[0][j], dp[0][j - 1][k - 1]);
                }
            }
            for (int i = 1; i < m; i++) {
                dp[i][0][0] = dp[i - 1][0][0] + coins[i][0];
                for (int k = 1; k <= r; k++) {
                    dp[i][0][k] = Math.max(dp[i - 1][0][k] + coins[i][0], dp[i - 1][0][k - 1]);
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) + coins[i][j];
                    for (int k = 1; k <= r; k++) {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]) + coins[i][j],
                                Math.max(dp[i - 1][j][k - 1], dp[i][j - 1][k - 1]));
                    }
                }
            }
            return dp[m - 1][n - 1][r];
        }
    }

}
