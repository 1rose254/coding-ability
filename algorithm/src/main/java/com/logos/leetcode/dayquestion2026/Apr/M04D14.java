package com.logos.leetcode.dayquestion2026.Apr;

import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/4/14 9:36
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D14 {

    /**
     * 2463. 最小移动总距离
     * <a href="https://leetcode.cn/problems/minimum-total-distance-traveled/description/"/>
     */

    class Solution {
        public long minimumTotalDistance(List<Integer> robotList, int[][] factory) {
            int[] robot = robotList.stream().mapToInt(i -> i).toArray();
            Arrays.sort(robot);
            Arrays.sort(factory, (a, b) -> a[0] - b[0]);

            int n = factory.length;
            int m = robot.length;
            long[][] dp = new long[n][m];
            for (long[] row : dp) {
                Arrays.fill(row, -1);
            }
            return dfs(n - 1, m - 1, robot, factory, dp);
        }

        private long dfs(int i, int j, int[] robot, int[][] factory, long[][] dp) {
            if (j < 0) {
                return 0;
            }
            if (i < 0) {
                return Long.MAX_VALUE / 2;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            long res = dfs(i - 1, j, robot, factory, dp);
            int position = factory[i][0];
            int limit = factory[i][1];
            long disSum = 0;
            for (int k = 1; k <= Math.min(j + 1, limit); k++) {
                disSum += Math.abs(robot[j - k + 1] - position);
                res = Math.min(res, dfs(i - 1, j - k, robot, factory, dp) + disSum);
            }
            dp[i][j] = res;
            return res;
        }
    }

}
