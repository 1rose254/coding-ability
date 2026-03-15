package com.logos.leetcode.hot100.dp;

/**
 * @author logos
 * date 2026/3/15 16:46
 * @version v1.0
 * @Package com.logos.leetcode.hot100.dp
 */
public class Q07 {

    /**
     * 300. 最长递增子序列
     */

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, dfs(i, nums, dp));
            }
            return ans;
        }

        private int dfs(int i, int[] nums, int[] dp) {
            if (dp[i] > 0) {
                return dp[i];
            }
            int ans = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    ans = Math.max(ans, dfs(j, nums, dp));
                }
            }
            ans++;
            return dp[i] = ans;
        }
    }

    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int ans = 0;
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                ans = Math.max(ans, ++dp[i]);
            }
            return ans;
        }
    }

}
