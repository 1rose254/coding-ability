package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/26 10:13
 * @version v1.0
 */
public class M10D26 {


    /**
     * 3619. 总价值可以被 K 整除的岛屿数目
     * <a href="https://leetcode.cn/problems/count-islands-with-total-value-divisible-by-k/description/"/>
     */

    class Solution {
        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        public int countIslands(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > 0 && dfs(i, j, grid) % k == 0) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private long dfs(int i, int j, int[][] grid) {
            long res = grid[i][j];
            grid[i][j] = 0;
            for (int[] d : DIRS) {
                int x = i + d[0], y = j + d[1];
                if (0 <= x && x < grid.length && 0 <= y && y < grid[x].length && grid[x][y] > 0) {
                    res += dfs(x, y, grid);
                }
            }
            return res;
        }
    }

}
