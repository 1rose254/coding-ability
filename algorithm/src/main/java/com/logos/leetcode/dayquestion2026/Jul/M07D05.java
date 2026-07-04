package com.logos.leetcode.dayquestion2026.Jul;

import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/7/5 0:02
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D05 {

    /**
     * 1301. 最大得分的路径数目
     * <a href="https://leetcode.cn/problems/number-of-paths-with-max-score/description/"/>
     */

    class Solution {
        public int[] pathsWithMaxScore(List<String> board) {
            final int MOD = 1_000_000_007;
            int m = board.size();
            int n = board.get(0).length();
            int[][] maxSum = new int[m + 1][n + 1];
            int[][] ways = new int[m + 1][n + 1];
            for (int[] row : maxSum) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
            maxSum[0][0] = 0;
            ways[0][0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char ch = board.get(i).charAt(j);
                    if (ch == 'X') {
                        continue;
                    }
                    maxSum[i + 1][j + 1] = Math.max(Math.max(maxSum[i][j], maxSum[i][j + 1]), maxSum[i + 1][j]);
                    int s = maxSum[i + 1][j + 1];
                    long w = 0;
                    if (maxSum[i][j] == s) {
                        w += ways[i][j];
                    }
                    if (maxSum[i][j + 1] == s) {
                        w += ways[i][j + 1];
                    }
                    if (maxSum[i + 1][j] == s) {
                        w += ways[i + 1][j];
                    }
                    ways[i + 1][j + 1] = (int) (w % MOD);
                    if ('1' <= ch && ch <= '9') {
                        maxSum[i + 1][j + 1] += ch - '0';
                    }
                }
            }
            return maxSum[m][n] < 0 ? new int[]{0, 0} : new int[]{maxSum[m][n], ways[m][n]};
        }
    }

}
