package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/29 09:15
 * @version v1.0
 */
public class M09D29 {

    /**
     * 2267. 检查是否有合法括号字符串路径
     * <a href="https://leetcode.cn/problems/check-if-there-is-a-valid-parentheses-string-path/description/"/>
     */

    class Solution {
        public boolean hasValidPath(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            if ((m + n) % 2 == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
                return false;
            }

            boolean[][][] vis = new boolean[m][n][(m + n + 1) / 2];
            return dfs(0, 0, 0, grid, vis);
        }

        private boolean dfs(int x, int y, int c, char[][] grid, boolean[][][] vis) {
            int m = grid.length;
            int n = grid[0].length;
            if (c > m - x + n - y - 1) {
                return false;
            }
            if (x == m - 1 && y == n - 1) {
                return c == 1;
            }

            if (vis[x][y][c]) {
                return false;
            }
            vis[x][y][c] = true;

            c += grid[x][y] == '(' ? 1 : -1;
            if (c < 0) {
                return false;
            }
            return x < m - 1 && dfs(x + 1, y, c, grid, vis) ||
                    y < n - 1 && dfs(x, y + 1, c, grid, vis);
        }
    }

}
