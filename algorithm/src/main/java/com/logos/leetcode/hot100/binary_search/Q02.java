package com.logos.leetcode.hot100.binary_search;

/**
 * @author logos
 * date 2026/3/8 15:31
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_search
 */
public class Q02 {

    /**
     * 74. 搜索二维矩阵
     */

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            int m = matrix[0].length;
            int i = 0;
            int j = m - 1;
            while (i < n && j >= 0) {
                if (matrix[i][j] < target) {
                    i++;
                } else if (matrix[i][j] > target) {
                    j--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

}
