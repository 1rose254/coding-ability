package com.logos.leetcode.dayquestion2026.Apr;

/**
 * @author logos
 * date 2026/4/29 10:20
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D29 {

    /**
     * 3225. 网格图操作后的最大分数
     * <a href="https://leetcode.cn/problems/maximum-score-from-grid-operations/description/"/>
     */

    class Solution {
        public long maximumScore(int[][] grid) {
            int n = grid.length;
            long[][] colSum = new long[n][n + 1];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    colSum[j][i + 1] = colSum[j][i] + grid[i][j];
                }
            }

            long[][][] f = new long[n][n + 1][2];
            for (int j = 0; j < n - 1; j++) {
                for (int pre = 0; pre <= n; pre++) {
                    for (int dec = 0; dec < 2; dec++) {
                        long res = 0;
                        for (int cur = 0; cur <= n; cur++) {
                            if (cur == pre) {
                                res = Math.max(res, f[j][cur][0]);
                            } else if (cur < pre) {
                                res = Math.max(res, f[j][cur][1] + colSum[j][pre] - colSum[j][cur]);
                            } else if (dec == 0) {
                                res = Math.max(res, f[j][cur][0] + colSum[j + 1][cur] - colSum[j + 1][pre]);
                            } else if (pre == 0) {
                                res = Math.max(res, f[j][cur][0]);
                            }
                        }
                        f[j + 1][pre][dec] = res;
                    }
                }
            }

            long ans = 0;
            for (long[] row : f[n - 1]) {
                ans = Math.max(ans, row[0]);
            }
            return ans;
        }
    }

}
