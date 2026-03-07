package com.logos.leetcode.hot100.graph_theory;

/**
 * @author logos
 * date 2026/3/7 10:31
 * @version v1.0
 * @Package com.logos.leetcode.hot100.graph_theory
 */
public class Q01 {

    /**
     * 200. 岛屿数量
     */

    class Solution {
        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        cnt++;
                        dfs(grid, i, j);
                    }
                }
            }
            return cnt;
        }

        private void dfs(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
                return;
            }
            grid[i][j] = '2';
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
        }
    }

}
