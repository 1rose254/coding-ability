package com.logos.leetcode.dayquestion2026.Jan;

/**
 * @author logos
 * date 2026/1/19 0:17
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jan
 */
public class M01D19 {

    /**
     * 1292. 元素和小于等于阈值的正方形的最大边长
     * <a href="https://leetcode.cn/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/description/"/>
     */
    class Solution {
        public int maxSideLength(int[][] mat, int threshold) {
            int m = mat.length;
            int n = mat[0].length;
            int[][] sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + mat[i][j];
                }
            }

            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 边长为 ans+1 的正方形，左上角在 (i, j)，右下角在 (i+ans, j+ans)
                    while (i + ans < m && j + ans < n && query(sum, i, j, i + ans, j + ans) <= threshold) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        // 返回左上角在 (r1, c1)，右下角在 (r2, c2) 的子矩阵元素和
        private int query(int[][] sum, int r1, int c1, int r2, int c2) {
            return sum[r2 + 1][c2 + 1] - sum[r2 + 1][c1] - sum[r1][c2 + 1] + sum[r1][c1];
        }
    }
}
