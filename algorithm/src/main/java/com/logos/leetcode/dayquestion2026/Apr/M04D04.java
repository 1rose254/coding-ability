package com.logos.leetcode.dayquestion2026.Apr;

/**
 * @author logos
 * date 2026/4/4 17:45
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D04 {

    /**
     * 2087. 网格图中机器人回家的最小代价
     * <a href="https://leetcode.cn/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/description/"/>
     */

    class Solution {
        public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
            int x0 = startPos[0];
            int y0 = startPos[1];
            int x1 = homePos[0];
            int y1 = homePos[1];
            int ans = -rowCosts[x0] - colCosts[y0];
            int l1 = Math.min(x0, x1);
            int r1 = Math.max(x0, x1);
            for (int i = l1; i <= r1; i++) {
                ans += rowCosts[i];
            }

            int l2 = Math.min(y0, y1);
            int r2 = Math.max(y0, y1);
            for (int i = l2; i <= r2; i++) {
                ans += colCosts[i];
            }

            return ans;
        }
    }

}
