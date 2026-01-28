package com.logos.leetcode.dayquestion2026.Jan;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/1/28 11:04
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jan
 */
public class M01D28 {

    /**
     * 3651. 带传送的最小路径成本
     * <a href="https://leetcode.cn/problems/minimum-cost-path-with-teleportations/description/"/>
     */

    class Solution {
        public int minCost(int[][] grid, int k) {
            int n = grid[0].length;
            int mx = 0;
            for (int[] row : grid) {
                for (int x : row) {
                    mx = Math.max(mx, x);
                }
            }

            int[] sufMinF = new int[mx + 2];
            Arrays.fill(sufMinF, Integer.MAX_VALUE);
            int[] minF = new int[mx + 1];
            int[] f = new int[n + 1];

            for (int t = 0; t <= k; t++) {
                Arrays.fill(minF, Integer.MAX_VALUE);

                Arrays.fill(f, Integer.MAX_VALUE / 2);
                f[1] = -grid[0][0];
                for (int[] row : grid) {
                    for (int j = 0; j < n; j++) {
                        int x = row[j];
                        f[j + 1] = Math.min(Math.min(f[j], f[j + 1]) + x, sufMinF[x]);
                        minF[x] = Math.min(minF[x], f[j + 1]);
                    }
                }

                for (int i = mx; i >= 0; i--) {
                    sufMinF[i] = Math.min(sufMinF[i + 1], minF[i]);
                }
            }

            return f[n];
        }
    }

}
