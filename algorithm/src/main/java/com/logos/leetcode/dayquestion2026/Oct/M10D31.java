package com.logos.leetcode.dayquestion2026.Oct;

import java.util.Arrays;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/31 11:34
 * @version v1.0
 */
public class M10D31 {

    /**
     * 3665. 统计镜子反射路径数目
     * <a href="https://leetcode.cn/problems/twisted-mirror-path-count/description/"/>
     */

    class Solution {
        private static final int MOD = 1_000_000_007;

        public int uniquePaths(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][][] memo = new int[m][n][2];
            for (int[][] mat : memo) {
                for (int[] row : mat) {
                    Arrays.fill(row, -1);
                }
            }
            return dfs(m - 1, n - 1, 0, memo, grid);
        }

        private int dfs(int i, int j, int k, int[][][] memo, int[][] grid) {
            if (i < 0 || j < 0) {
                return 0;
            }
            if (i == 0 && j == 0) {
                return 1;
            }
            if (memo[i][j][k] != -1) {
                return memo[i][j][k];
            }
            int res;
            if (grid[i][j] == 0) {
                res = (dfs(i, j - 1, 0, memo, grid) + dfs(i - 1, j, 1, memo, grid)) % MOD;
            } else if (k == 0) {
                res = dfs(i - 1, j, 1, memo, grid);
            } else {
                res = dfs(i, j - 1, 0, memo, grid);
            }
            return memo[i][j][k] = res;
        }
    }

}
