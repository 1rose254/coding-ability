package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/4 11:53
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D04 {

    /**
     * 48. 旋转图像
     * <a href="https://leetcode.cn/problems/rotate-image/description/"/>
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
