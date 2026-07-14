package com.logos.leetcode.dayquestion2026.Jul;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/7/14 19:36
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D14 {

    /**
     * 3336. 最大公约数相等的子序列数量
     * <a href="https://leetcode.cn/problems/find-the-number-of-subsequences-with-equal-gcd/description/"/>
     */

    class Solution {
        private static final int MOD = 1_000_000_007;

        public int subsequencePairCount(int[] nums) {
            int n = nums.length;
            int m = 0;
            for (int x : nums) {
                m = Math.max(m, x);
            }
            int[][][] memo = new int[n][m + 1][m + 1];
            for (int[][] mat : memo) {
                for (int[] row : mat) {
                    Arrays.fill(row, -1);
                }
            }
            return (dfs(n - 1, 0, 0, nums, memo) - 1 + MOD) % MOD;
        }

        private int dfs(int i, int j, int k, int[] nums, int[][][] memo) {
            if (i < 0) {
                return j == k ? 1 : 0;
            }
            if (memo[i][j][k] < 0) {
                long res = (long) dfs(i - 1, j, k, nums, memo) +
                        dfs(i - 1, gcd(j, nums[i]), k, nums, memo) +
                        dfs(i - 1, j, gcd(k, nums[i]), nums, memo);
                memo[i][j][k] = (int) (res % MOD);
            }
            return memo[i][j][k];
        }

        private int gcd(int a, int b) {
            while (a != 0) {
                int tmp = a;
                a = b % a;
                b = tmp;
            }
            return b;
        }
    }

}
