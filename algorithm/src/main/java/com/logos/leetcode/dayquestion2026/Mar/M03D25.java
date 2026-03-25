package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/25 9:43
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D25 {

    /**
     * 3546. 等和矩阵分割 I
     * <a href="https://leetcode.cn/problems/equal-sum-grid-partition-i/description/"/>
     */

    class Solution {
        public boolean canPartitionGrid(int[][] grid) {
            long total = 0;
            for (int[] row : grid) {
                for (int x : row) {
                    total += x;
                }
            }
            return check(grid, total) || check(rotate(grid), total);
        }

        private boolean check(int[][] a, long total) {
            long s = 0;
            for (int i = 0; i < a.length - 1; i++) {
                for (int x : a[i]) {
                    s += x;
                }
                if (s * 2 == total) {
                    return true;
                }
            }
            return false;
        }

        private int[][] rotate(int[][] a) {
            int m = a.length;
            int n = a[0].length;
            int[][] b = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    b[j][m - 1 - i] = a[i][j];
                }
            }
            return b;
        }
    }

}
