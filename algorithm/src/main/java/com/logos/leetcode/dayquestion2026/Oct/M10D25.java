package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/25 10:10
 * @version v1.0
 */
public class M10D25 {

    /**
     * 1254. 统计封闭岛屿的数目
     * <a href="https://leetcode.cn/problems/number-of-closed-islands/description/"/>
     */

    class Solution {
        public int closedIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            if (m < 3 || n < 3) {
                return 0;
            }
            for (int i = 0; i < m; i++) {
                int step = i == 0 || i == m - 1 ? 1 : n - 1;
                for (int j = 0; j < n; j += step)
                    dfs(grid, i, j);
            }

            int ans = 0;
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (grid[i][j] == 0) {
                        ans++;
                        dfs(grid, i, j);
                    }
                }
            }
            return ans;
        }

        private void dfs(int[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] != 0)
                return;
            grid[x][y] = 1;
            dfs(grid, x - 1, y);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x, y + 1);
        }
    }

}
