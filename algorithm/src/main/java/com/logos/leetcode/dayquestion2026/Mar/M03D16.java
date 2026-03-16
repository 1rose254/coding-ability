package com.logos.leetcode.dayquestion2026.Mar;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/3/16 9:30
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D16 {

    /**
     * 1878. 矩阵中最大的三个菱形和
     * <a href="https://leetcode.cn/problems/get-biggest-three-rhombus-sums-in-a-grid/description/"/>
     */

    class Solution {
        private int x, y, z;

        public int[] getBiggestThree(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] diagSum = new int[m + 1][n + 1];
            int[][] antiSum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int v = grid[i][j];
                    diagSum[i + 1][j + 1] = diagSum[i][j] + v;
                    antiSum[i + 1][j] = antiSum[i][j + 1] + v;
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    update(grid[i][j]);
                    int mx = Math.min(Math.min(i, m - 1 - i), Math.min(j, n - 1 - j));
                    for (int k = 1; k <= mx; k++) {
                        int a = queryDiagonal(diagSum, i - k, j, k);
                        int b = queryDiagonal(diagSum, i, j - k, k);
                        int c = queryAntiDiagonal(antiSum, i - k + 1, j - 1, k - 1);
                        int d = queryAntiDiagonal(antiSum, i, j + k, k + 1);
                        update(a + b + c + d);
                    }
                }
            }

            int[] ans = new int[]{x, y, z};
            int len = 3;
            while (ans[len - 1] == 0) {
                len--;
            }
            return Arrays.copyOf(ans, len);
        }

        private int queryDiagonal(int[][] diagSum, int x, int y, int k) {
            return diagSum[x + k][y + k] - diagSum[x][y];
        }

        private int queryAntiDiagonal(int[][] antiSum, int x, int y, int k) {
            return antiSum[x + k][y + 1 - k] - antiSum[x][y + 1];
        }

        private void update(int v) {
            if (v > x) {
                z = y;
                y = x;
                x = v;
            } else if (v < x && v > y) {
                z = y;
                y = v;
            } else if (v < y && v > z) {
                z = v;
            }
        }
    }

}
