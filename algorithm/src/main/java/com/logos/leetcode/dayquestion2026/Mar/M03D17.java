package com.logos.leetcode.dayquestion2026.Mar;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/3/17 8:46
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D17 {

    /**
     * 1727. 重新排列后的最大子矩阵
     * <a href="https://leetcode.cn/problems/largest-submatrix-with-rearrangements/description/"/>
     */

    class Solution {
        public int largestSubmatrix(int[][] matrix) {
            int n = matrix[0].length;
            int[] heights = new int[n];
            int ans = 0;
            for (int[] row : matrix) {
                for (int j = 0; j < n; j++) {
                    if (row[j] == 0) {
                        heights[j] = 0;
                    } else {
                        heights[j]++;
                    }
                }

                int[] hs = heights.clone();
                Arrays.sort(hs);
                for (int i = 0; i < n; i++) {
                    ans = Math.max(ans, (n - i) * hs[i]);
                }
            }
            return ans;
        }
    }

}
