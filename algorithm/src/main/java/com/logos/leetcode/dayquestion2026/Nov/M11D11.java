package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/11 12:46
 * @version v1.0
 */
public class M11D11 {

    /**
     * 3789. 采购的最小花费
     * <a href="https://leetcode.cn/problems/minimum-cost-to-acquire-required-items/description/"/>
     */

    class Solution {
        public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
            long res1 = (long) cost1 * need1 + (long) cost2 * need2;
            if (need1 > need2) {
                int tmp = need1;
                need1 = need2;
                need2 = tmp;
                cost2 = cost1;
            }
            long res2 = (long) costBoth * need2;
            long res3 = (long) costBoth * need1 + (long) cost2 * (need2 - need1);
            return Math.min(res1, Math.min(res2, res3));
        }
    }

}
