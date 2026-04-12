package com.logos.leetcode.dayquestion2026.Apr;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/4/12 9:02
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D12 {

    /**
     * 1320. 二指输入的的最小距离
     * <a href="https://leetcode.cn/problems/minimum-distance-to-type-a-word-using-two-fingers/description/"/>
     */

    class Solution {
        private static final int[][] dis = new int[26][26];

        static {
            final int COLUMN = 6;
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dis[i][j] = Math.abs(i / COLUMN - j / COLUMN) + Math.abs(i % COLUMN - j % COLUMN);
                }
            }
        }

        public int minimumDistance(String word) {
            char[] s = word.toCharArray();
            int n = s.length;

            int[][][] dp = new int[n][26][26];
            for (int[][] mat : dp) {
                for (int[] row : mat) {
                    Arrays.fill(row, -1);
                }
            }

            int ans = Integer.MAX_VALUE;
            for (int finger2 = 0; finger2 < 26; finger2++) {
                ans = Math.min(ans, dfs(n - 2, s[n - 1] - 'A', finger2, s, dp));
            }
            return ans;
        }

        private int dfs(int i, int finger1, int finger2, char[] word, int[][][] dp) {
            if (i < 0) {
                return 0;
            }

            if (dp[i][finger1][finger2] != -1) {
                return dp[i][finger1][finger2];
            }

            int w = word[i] - 'A';
            int res1 = dfs(i - 1, w, finger2, word, dp) + dis[finger1][w];

            int res2 = dfs(i - 1, finger1, w, word, dp) + dis[finger2][w];

            int res = Math.min(res1, res2);
            dp[i][finger1][finger2] = res;
            return res;
        }
    }

}
