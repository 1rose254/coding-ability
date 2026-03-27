package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/27 19:27
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D27 {

    /**
     * 2946. 循环移位后的矩阵相似检查
     * <a href="https://leetcode.cn/problems/matrix-similarity-after-cyclic-shifts/description/"/>
     */

    class Solution {
        public boolean areSimilar(int[][] mat, int k) {
            int n = mat[0].length;
            for (int[] row : mat) {
                for (int j = 0; j < n; j++) {
                    if (row[j] != row[(j + k) % n]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
