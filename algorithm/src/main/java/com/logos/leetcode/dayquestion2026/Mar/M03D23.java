package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/23 9:33
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D23 {

    /**
     * 1594. 矩阵的最大非负积
     * <a href="https://leetcode.cn/problems/maximum-non-negative-product-in-a-matrix/description/"/>
     */

    class Solution {
        public int maxProductPath(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            long[][][] dp = new long[m][n][2];
            for (long[][] row : dp) {
                for (long[] p : row) {
                    p[0] = p[1] = Long.MIN_VALUE;
                }
            }

            long ans = dfs(m - 1, n - 1, grid, dp)[1];
            return ans < 0 ? -1 : (int) (ans % 1_000_000_007);
        }

        private long[] dfs(int i, int j, int[][] grid, long[][][] dp) {
            long x = grid[i][j];
            if (i == 0 && j == 0) {
                return new long[]{x, x};
            }

            long[] p = dp[i][j];
            if (p[0] != Long.MIN_VALUE) {
                return p;
            }

            long resMin = Long.MAX_VALUE;
            long resMax = Long.MIN_VALUE;
            if (i > 0) {
                long[] res = dfs(i - 1, j, grid, dp);
                long mn = res[0], mx = res[1];
                resMin = Math.min(mn * x, mx * x);
                resMax = Math.max(mn * x, mx * x);
            }
            if (j > 0) {
                long[] res = dfs(i, j - 1, grid, dp);
                long mn = res[0], mx = res[1];
                resMin = Math.min(resMin, Math.min(mn * x, mx * x));
                resMax = Math.max(resMax, Math.max(mn * x, mx * x));
            }

            p[0] = resMin;
            p[1] = resMax;
            return p;
        }
    }

}
