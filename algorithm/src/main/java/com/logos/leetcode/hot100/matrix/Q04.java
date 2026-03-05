package com.logos.leetcode.hot100.matrix;

/**
 * @author logos
 * date 2026/3/5 21:37
 * @version v1.0
 * @Package com.logos.leetcode.hot100.matrix
 */
public class Q04 {

    /**
     * 240. 搜索二维矩阵 II
     */

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            int m = matrix[0].length;
            int i = 0;
            int j = m - 1;
            while (i < n && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return false;
        }
    }

}
