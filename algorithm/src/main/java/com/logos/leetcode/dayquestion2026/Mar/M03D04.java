package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/4 10:49
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D04 {

    /**
     * 1582. 二进制矩阵中的特殊位置
     * <a href="https://leetcode.cn/problems/special-positions-in-a-binary-matrix/description/"/>
     */

    class Solution {
        public int numSpecial(int[][] mat) {
            int ans = 0;
            for (int[] row : mat) {
                int rowSum = 0;
                int j = -1;
                for (int i = 0; i < row.length; i++) {
                    if (row[i] == 1) {
                        rowSum++;
                        j = i;
                    }
                }
                if (rowSum != 1) {
                    continue;
                }

                int colSum = 0;
                for (int[] r : mat) {
                    colSum += r[j];
                }
                if (colSum == 1) {
                    ans++;
                }
            }
            return ans;
        }
    }

}
