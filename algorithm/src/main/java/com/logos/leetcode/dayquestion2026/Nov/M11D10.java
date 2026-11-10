package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/10 12:06
 * @version v1.0
 */
public class M11D10 {

    /**
     * 3693. 爬楼梯 II
     * <a href="https://leetcode.cn/problems/climbing-stairs-ii/description/"/>
     */

    class Solution {
        public int climbStairs(int n, int[] costs) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int res = Integer.MAX_VALUE;
                for (int j = Math.max(i - 3, 0); j < i; j++) {
                    res = Math.min(res, dp[j] + (i - j) * (i - j));
                }
                dp[i] = res + costs[i - 1];
            }
            return dp[n];
        }
    }

}
