package com.logos.leetcode.hot100.dp;

/**
 * @author logos
 * date 2026/3/15 17:08
 * @version v1.0
 * @Package com.logos.leetcode.hot100.dp
 */
public class Q09 {

    /**
     * 416. 分割等和子集
     */

    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int x : nums) {
                sum += x;
            }
            if (sum % 2 != 0) {
                return false;
            }
            sum /= 2;
            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
            int s2 = 0;
            for (int x : nums) {
                s2 = Math.min(s2 + x, sum);
                for (int j = s2; j >= x; j--) {
                    dp[j] = dp[j] || dp[j - x];
                }
                if (dp[sum]) {
                    return true;
                }
            }
            return false;
        }
    }

}
