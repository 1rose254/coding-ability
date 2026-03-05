package com.logos.leetcode.hot100.matrix;

/**
 * @author logos
 * date 2026/3/5 21:30
 * @version v1.0
 * @Package com.logos.leetcode.hot100.matrix
 */
public class Q03 {

    /**
     * 48. 旋转图像
     */

    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = tmp;
                }
            }
        }
    }

}
