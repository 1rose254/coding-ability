package com.logos.leetcode.dayquestion2026.May;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/5/2 10:45
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D02 {

    /**
     * 788. 旋转数字
     * <a href="https://leetcode.cn/problems/rotated-digits/description/"/>
     */

    class Solution {
        private static int[] DIFFS = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

        public int rotatedDigits(int n) {
            char[] s = Integer.toString(n).toCharArray();
            int[][] memo = new int[s.length][2];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dfs(0, 0, true, s, memo);
        }

        private int dfs(int i, int hasDiff, boolean isLimit, char[] s, int[][] memo) {
            if (i == s.length) {
                return hasDiff;
            }
            if (!isLimit && memo[i][hasDiff] >= 0) {
                return memo[i][hasDiff];
            }
            int res = 0;
            int up = isLimit ? s[i] - '0' : 9;
            for (int d = 0; d <= up; d++) {
                if (DIFFS[d] != -1) {
                    res += dfs(i + 1, hasDiff | DIFFS[d], isLimit && d == up, s, memo);
                }
            }
            if (!isLimit) {
                memo[i][hasDiff] = res;
            }
            return res;
        }
    }

}
