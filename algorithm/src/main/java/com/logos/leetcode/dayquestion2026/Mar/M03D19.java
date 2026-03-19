package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/19 9:04
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D19 {

    /**
     * 3212. 统计 X 和 Y 频数相等的子矩阵数量
     * <a href="https://leetcode.cn/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/"/>
     */

    class Solution {
        public int numberOfSubmatrices(char[][] grid) {
            int ans = 0;
            int[][] colCnt = new int[grid[0].length][2];
            for (char[] row : grid) {
                int s0 = 0;
                int s1 = 0;
                for (int j = 0; j < row.length; j++) {
                    if (row[j] != '.') {
                        colCnt[j][row[j] & 1]++;
                    }
                    s0 += colCnt[j][0];
                    s1 += colCnt[j][1];
                    if (s0 > 0 && s0 == s1) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

}
