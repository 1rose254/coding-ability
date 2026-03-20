package com.logos.leetcode.dayquestion2026.Mar;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/3/20 9:35
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D20 {

    /**
     * 3567. 子矩阵的最小绝对差
     * <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-sliding-submatrix/description/"/>
     */

    class Solution {
        public int[][] minAbsDiff(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] ans = new int[m - k + 1][n - k + 1];
            int[] a = new int[k * k];
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    int idx = 0;
                    for (int x = 0; x < k; x++) {
                        for (int y = 0; y < k; y++) {
                            a[idx++] = grid[i + x][j + y];
                        }
                    }
                    Arrays.sort(a);
                    int res = Integer.MAX_VALUE;
                    for (int p = 1; p < a.length; p++) {
                        if (a[p] > a[p - 1]) {
                            res = Math.min(res, a[p] - a[p - 1]);
                        }
                    }
                    if (res < Integer.MAX_VALUE) {
                        ans[i][j] = res;
                    }
                }
            }
            return ans;
        }
    }

}
