package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/24 9:31
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D24 {

    /**
     * 2906. 构造乘积矩阵
     * <a href="https://leetcode.cn/problems/construct-product-matrix/description/"/>
     */

    class Solution {
        public int[][] constructProductMatrix(int[][] grid) {
            final int MOD = 12345;
            int n = grid.length;
            int m = grid[0].length;
            int[][] ans = new int[n][m];

            long suf = 1;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    ans[i][j] = (int) suf;
                    suf = suf * grid[i][j] % MOD;
                }
            }

            long pre = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ans[i][j] = (int) (ans[i][j] * pre % MOD);
                    pre = pre * grid[i][j] % MOD;
                }
            }

            return ans;
        }
    }

}
