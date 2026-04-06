package com.logos.leetcode.dayquestion2026.Apr;

import java.util.HashSet;

/**
 * @author logos
 * date 2026/4/6 11:17
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D06 {

    /**
     * 874. 模拟行走机器人
     * <a href="https://leetcode.cn/problems/walking-robot-simulation/description/"/>
     */

    class Solution {
        private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int robotSim(int[] commands, int[][] obstacles) {
            HashSet<Integer> obstacleSet = new HashSet<>(obstacles.length, 1);
            final int OFFSET = (int) 3e4;
            for (int[] p : obstacles) {
                obstacleSet.add((p[0] + OFFSET) << 16 | (p[1] + OFFSET));
            }

            int x = 0;
            int y = 0;
            int k = 0;
            int ans = 0;
            for (int c : commands) {
                if (c < 0) {
                    k = (k + c * 2 + 7) % 4;
                    continue;
                }
                while (c-- > 0) {
                    int nx = x + DIRS[k][0];
                    int ny = y + DIRS[k][1];
                    if (obstacleSet.contains((nx + OFFSET) << 16 | (ny + OFFSET))) {
                        break;
                    }
                    x = nx;
                    y = ny;
                }
                ans = Math.max(ans, x * x + y * y);
            }
            return ans;
        }
    }

}
