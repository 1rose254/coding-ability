package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/10 11:15
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D10 {

    /**
     * 2770. 达到末尾下标所需的最大跳跃次数
     * <a href="https://leetcode.cn/problems/maximum-number-of-jumps-to-reach-the-last-index/description/"/>
     */

    class Solution {
        public int maximumJumps(int[] nums, int target) {
            int n = nums.length;
            int[] memo = new int[n];
            int ans = dfs(n - 1, nums, target, memo);
            return ans < 0 ? -1 : ans;
        }

        private int dfs(int j, int[] nums, int target, int[] memo) {
            if (j == 0) {
                return 0;
            }

            if (memo[j] != 0) {
                return memo[j];
            }

            int res = Integer.MIN_VALUE;
            for (int i = 0; i < j; i++) {
                if (Math.abs(nums[i] - nums[j]) <= target) {
                    res = Math.max(res, dfs(i, nums, target, memo) + 1);
                }
            }
            memo[j] = res;
            return res;
        }
    }

}
