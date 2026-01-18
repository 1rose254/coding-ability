package com.logos.leetcode.dayQuestion2026.Jan;

/**
 * @author logos
 * date 2026/1/18 23:49
 * @version v1.0
 * @Package com.logos.leetcode.dayQuestion2026.Jan
 */
public class M01D18 {


    /**
     * 1895. 最大的幻方
     * <a href="https://leetcode.cn/problems/largest-magic-square/description/"/>
     */
    class Solution {
        public int largestMagicSquare(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] rowSum = new int[m][n + 1];      // → 前缀和
            int[][] colSum = new int[m + 1][n];      // ↓ 前缀和
            int[][] diagSum = new int[m + 1][n + 1]; // ↘ 前缀和
            int[][] antiSum = new int[m + 1][n + 1]; // ↙ 前缀和

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int x = grid[i][j];
                    rowSum[i][j + 1] = rowSum[i][j] + x;
                    colSum[i + 1][j] = colSum[i][j] + x;
                    diagSum[i + 1][j + 1] = diagSum[i][j] + x;
                    antiSum[i + 1][j] = antiSum[i][j + 1] + x;
                }
            }

            // k×k 子矩阵的左上角为 (i−k, j−k)，右下角为 (i−1, j−1)
            for (int k = Math.min(m, n); ; k--) {
                for (int i = k; i <= m; i++) {
                    next:
                    for (int j = k; j <= n; j++) {
                        // 子矩阵主对角线的和
                        int sum = diagSum[i][j] - diagSum[i - k][j - k];

                        // 子矩阵反对角线的和
                        if (antiSum[i][j - k] - antiSum[i - k][j] != sum) {
                            continue;
                        }

                        // 子矩阵每行的和
                        for (int r = i - k; r < i; r++) {
                            if (rowSum[r][j] - rowSum[r][j - k] != sum) {
                                continue next;
                            }
                        }

                        // 子矩阵每列的和
                        for (int c = j - k; c < j; c++) {
                            if (colSum[i][c] - colSum[i - k][c] != sum) {
                                continue next;
                            }
                        }

                        return k;
                    }
                }
            }
        }
    }
}
