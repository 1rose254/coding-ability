package com.logos.leetcode.dayquestion2026.Jun;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/6/20 11:07
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D20 {

    /**
     * 1840. 最高建筑高度
     * <a href="https://leetcode.cn/problems/maximum-building-height/description/"/>
     */

    class Solution {
        public int maxBuilding(int n, int[][] restrictions) {
            int m = restrictions.length;
            if (m == 0) {
                return n - 1;
            }
            Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);

            int[] h = new int[m];
            h[0] = Math.min(restrictions[0][0] - 1, restrictions[0][1]);
            for (int i = 1; i < m; i++) {
                h[i] = Math.min(h[i - 1] + restrictions[i][0] - restrictions[i - 1][0], restrictions[i][1]);
            }
            for (int i = m - 2; i >= 0; i--) {
                h[i] = Math.min(h[i], h[i + 1] + restrictions[i + 1][0] - restrictions[i][0]);
            }

            int ans = Math.max((restrictions[0][0] - 1 + h[0]) / 2, h[m - 1] + n - restrictions[m - 1][0]);
            for (int i = 0; i < m - 1; i++) {
                ans = Math.max(ans, (restrictions[i + 1][0] - restrictions[i][0] + h[i] + h[i + 1]) / 2);
            }
            return ans;
        }
    }

}
