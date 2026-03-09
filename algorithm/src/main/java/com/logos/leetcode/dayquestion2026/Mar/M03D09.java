package com.logos.leetcode.dayquestion2026.Mar;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/3/9 8:11
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D09 {

    /**
     * 3129. 找出所有稳定的二进制数组 I
     * <a href="https://leetcode.cn/problems/find-all-possible-stable-binary-arrays-i/description/"/>
     */

    class Solution {
        private static final int MOD = 1_000_000_007;

        public int numberOfStableArrays(int zero, int one, int limit) {
            int[][][] dp = new int[zero + 1][one + 1][2];
            for (int[][] m : dp) {
                for (int[] m2 : m) {
                    Arrays.fill(m2, -1);
                }
            }
            return (dfs(zero, one, 0, limit, dp) + dfs(zero, one, 1, limit, dp)) % MOD;
        }

        private int dfs(int i, int j, int k, int limit, int[][][] dp) {
            if (i == 0) {
                return k == 1 && j <= limit ? 1 : 0;
            }
            if (j == 0) {
                return k == 0 && i <= limit ? 1 : 0;
            }
            if (dp[i][j][k] != -1) {
                return dp[i][j][k];
            }
            if (k == 0) {
                dp[i][j][k] = (int) (((long) dfs(i - 1, j, 0, limit, dp) + dfs(i - 1, j, 1, limit, dp) +
                        (i > limit ? MOD - dfs(i - limit - 1, j, 1, limit, dp) : 0)) % MOD);
            } else {
                dp[i][j][k] = (int) (((long) dfs(i, j - 1, 0, limit, dp) + dfs(i, j - 1, 1, limit, dp) +
                        (j > limit ? MOD - dfs(i, j - limit - 1, 0, limit, dp) : 0)) % MOD);
            }
            return dp[i][j][k];
        }
    }

}
