package com.logos.leetcode.hot100.dp;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/3/13 22:59
 * @version v1.0
 * @Package com.logos.leetcode.hot100.dp
 */
public class Q05 {

    /**
     * 322. 零钱兑换
     */

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            Arrays.fill(dp[0], Integer.MAX_VALUE / 2);
            dp[0][0] = 0;
            for (int i = 0; i < n; i++) {
                for (int c = 0; c <= amount; c++) {
                    if (c < coins[i]) {
                        dp[i + 1][c] = dp[i][c];
                    } else {
                        dp[i + 1][c] = Math.min(dp[i][c], dp[i + 1][c - coins[i]] + 1);
                    }
                }
            }
            int ans = dp[n][amount];
            return ans < Integer.MAX_VALUE / 2 ? ans : -1;
        }
    }

}
