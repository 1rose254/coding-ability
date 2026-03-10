package com.logos.leetcode.hot100.greedy_algorithm;

/**
 * @author logos
 * date 2026/3/9 17:10
 * @version v1.0
 * @Package com.logos.leetcode.hot100.greedy_algorithm
 */
public class Q01 {

    /**
     * 121. 买卖股票的最佳时机
     */

    class Solution {
        public int maxProfit(int[] prices) {
            int ans = 0;
            int pre = Integer.MAX_VALUE;
            for (int i = 0; i < prices.length; i++) {
                pre = Math.min(pre, prices[i]);
                ans = Math.max(ans, prices[i] - pre);
            }
            return ans;
        }
    }

}
