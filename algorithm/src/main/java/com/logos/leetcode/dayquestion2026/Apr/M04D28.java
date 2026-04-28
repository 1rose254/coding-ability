package com.logos.leetcode.dayquestion2026.Apr;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/4/28 9:41
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D28 {

    /**
     * 2033. 获取单值网格的最小操作数
     * <a href="https://leetcode.cn/problems/minimum-operations-to-make-a-uni-value-grid/description/"/>
     */

    class Solution {
        public int minOperations(int[][] grid, int x) {
            int k = grid.length * grid[0].length;
            int[] a = new int[k];
            int idx = 0;
            int target = grid[0][0] % x;

            for (int[] row : grid) {
                for (int v : row) {
                    if (v % x != target) {
                        return -1;
                    }
                    a[idx++] = v;
                }
            }

            Arrays.sort(a);
            int median = a[k / 2];

            int ans = 0;
            for (int v : a) {
                ans += Math.abs(v - median);
            }
            return ans / x;
        }
    }

}
