package com.logos.leetcode.hot100.graph_theory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/7 19:26
 * @version v1.0
 * @Package com.logos.leetcode.hot100.graph_theory
 */
public class Q02 {

    /**
     * 994. 腐烂的橘子
     */

    class Solution {

        private static int[][] dir = new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

        public int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int fresh = 0;
            List<int[]> que = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        fresh++;
                    } else if (grid[i][j] == 2) {
                        que.add(new int[]{i, j});
                    }
                }
            }
            int ans = 0;
            while (fresh > 0 && !que.isEmpty()) {
                ans++;
                List<int[]> tmp = que;
                que = new ArrayList<>();
                for (int[] p : tmp) {
                    for (int[] d : dir) {
                        int x = p[0] + d[0];
                        int y = p[1] + d[1];
                        if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
                            fresh--;
                            grid[x][y] = 2;
                            que.add(new int[]{x, y});
                        }
                    }
                }
            }
            return fresh > 0 ? -1 : ans;
        }
    }

}
