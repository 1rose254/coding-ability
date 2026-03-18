package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/18 8:43
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D18 {

    /**
     * 3070. 元素和小于等于 k 的子矩阵的数目
     * <a href="https://leetcode.cn/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/description/"/>
     */

    class Solution {
        public int countSubmatrices(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] sum = new int[m + 1][n + 1];
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + grid[i][j];
                    if (sum[i + 1][j + 1] <= k) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

}
