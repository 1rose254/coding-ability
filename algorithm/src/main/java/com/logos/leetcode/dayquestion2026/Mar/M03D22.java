package com.logos.leetcode.dayquestion2026.Mar;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/3/22 9:49
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D22 {

    /**
     * 1886. 判断矩阵经轮转后是否一致
     * <a href="https://leetcode.cn/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/"/>
     */

    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            for (int i = 0; i < 4; i++) {
                if (Arrays.deepEquals(mat, target)) {
                    return true;
                }
                rotate(mat);
            }
            return false;
        }

        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                int[] row = matrix[i];
                for (int j = i + 1; j < n; j++) {
                    int tmp = row[j];
                    row[j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
                for (int j = 0; j < n / 2; j++) {
                    int tmp = row[j];
                    row[j] = row[n - 1 - j];
                    row[n - 1 - j] = tmp;
                }
            }
        }
    }

}
