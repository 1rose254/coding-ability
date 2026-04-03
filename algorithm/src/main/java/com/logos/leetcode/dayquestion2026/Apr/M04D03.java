package com.logos.leetcode.dayquestion2026.Apr;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/4/3 10:33
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D03 {

    /**
     * 3661. 可以被机器人摧毁的最大墙壁数目
     * <a href="https://leetcode.cn/problems/maximum-walls-destroyed-by-robots/description/"/>
     */

    class Solution {
        public int maxWalls(int[] robots, int[] distance, int[] walls) {
            int n = robots.length;
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = robots[i];
                a[i][1] = distance[i];
            }
            Arrays.sort(a, (p, q) -> p[0] - q[0]);
            Arrays.sort(walls);

            int[][] dp = new int[n][2];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return dfs(n - 1, 1, a, walls, dp);
        }

        private int dfs(int i, int j, int[][] a, int[] walls, int[][] dp) {
            if (i < 0) {
                return 0;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            int x = a[i][0], d = a[i][1];
            int leftX = x - d;
            if (i > 0) {
                leftX = Math.max(leftX, a[i - 1][0] + 1);
            }
            int left = lowerBound(walls, leftX);
            int cur = lowerBound(walls, x + 1);
            int resLeft = dfs(i - 1, 0, a, walls, dp) + cur - left;

            int rightX = x + d;
            if (i + 1 < a.length) {
                int x2 = a[i + 1][0];
                if (j == 0) {
                    x2 -= a[i + 1][1];
                }
                rightX = Math.min(rightX, x2 - 1);
            }
            int right = lowerBound(walls, rightX + 1);
            cur = lowerBound(walls, x);
            int resRight = dfs(i - 1, 1, a, walls, dp) + right - cur;
            return dp[i][j] = Math.max(resLeft, resRight);
        }

        private int lowerBound(int[] nums, int target) {
            int left = -1;
            int right = nums.length;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }
    }

}
