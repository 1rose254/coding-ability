package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/21 9:53
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D21 {

    /**
     * 3643. 垂直翻转子矩阵
     * <a href="https://leetcode.cn/problems/flip-square-submatrix-vertically/description/"/>
     */

    class Solution {
        public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
            int l = x;
            int r = x + k - 1;
            while (l < r) {
                for (int j = y; j < y + k; j++) {
                    int tmp = grid[l][j];
                    grid[l][j] = grid[r][j];
                    grid[r][j] = tmp;
                }
                l++;
                r--;
            }
            return grid;
        }
    }

}
