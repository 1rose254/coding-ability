package com.logos.leetcode.dayquestion2026.Apr;

/**
 * @author logos
 * date 2026/4/27 9:13
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D27 {

    /**
     * 1391. 检查网格中是否存在有效路径
     * <a href="https://leetcode.cn/problems/check-if-there-is-a-valid-path-in-a-grid/description/"/>
     */

    class Solution {
        private static final int[][][] dir = {
                {},
                { { 0, -1 }, { 0, 1 } },
                { { -1, 0 }, { 1, 0 } },
                { { 0, -1 }, { 1, 0 } },
                { { 0, 1 }, { 1, 0 } },
                { { 0, -1 }, { -1, 0 } },
                { { 0, 1 }, { -1, 0 } },
        };

        public boolean hasValidPath(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] vis = new boolean[m][n];
            return dfs(0, 0, grid, vis);
        }

        private boolean dfs(int x, int y, int[][] grid, boolean[][] vis) {
            int m = grid.length;
            int n = grid[x].length;
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            vis[x][y] = true;
            for (int[] d : dir[grid[x][y]]) {
                int i = x + d[0];
                int j = y + d[1];
                if (0 <= i && i < m && 0 <= j && j < n && !vis[i][j] &&
                        contains(grid[i][j], -d[0], -d[1]) && dfs(i, j, grid, vis)) {
                    return true;
                }
            }
            return false;
        }

        private boolean contains(int street, int dx, int dy) {
            int[][] ds = dir[street];
            return ds[0][0] == dx && ds[0][1] == dy ||
                    ds[1][0] == dx && ds[1][1] == dy;
        }
    }

}
