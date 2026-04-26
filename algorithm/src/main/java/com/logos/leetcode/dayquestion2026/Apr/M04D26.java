package com.logos.leetcode.dayquestion2026.Apr;

/**
 * @author logos
 * date 2026/4/26 10:29
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D26 {

    /**
     * 2854. 判断网格中是否存在循环
     * <a href="https://leetcode.cn/problems/detect-cycles-in-2d-grid/description/"/>
     */

    class Solution {
        private static final int[][] DIRS = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

        public boolean containsCycle(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] vis = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!vis[i][j] && dfs(i, j, -1, -1, grid, vis)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int x, int y, int px, int py, char[][] grid, boolean[][] vis) {
            vis[x][y] = true;
            for (int[] d : DIRS) {
                int i = x + d[0];
                int j = y + d[1];
                if ((i != px || j != py) &&
                        0 <= i && i < grid.length && 0 <= j && j < grid[i].length &&
                        grid[i][j] == grid[x][y] &&
                        (vis[i][j] || dfs(i, j, x, y, grid, vis))) {
                    return true;
                }
            }
            return false;
        }
    }

}
