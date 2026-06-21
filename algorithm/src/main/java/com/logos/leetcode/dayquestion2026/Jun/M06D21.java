package com.logos.leetcode.dayquestion2026.Jun;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/6/21 11:39
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D21 {

    /**
     * 1833. 雪糕的最大数量
     * <a href="https://leetcode.cn/problems/maximum-ice-cream-bars/description/"/>
     */
    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);
            int n = costs.length;
            for (int i = 0; i < n; i++) {
                int cost = costs[i];
                if (coins < cost) {
                    return i;
                }
                coins -= cost;
            }
            return n;
        }
    }

}
