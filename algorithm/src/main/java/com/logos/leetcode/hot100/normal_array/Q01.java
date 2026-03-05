package com.logos.leetcode.hot100.normal_array;

/**
 * @author logos
 * date 2026/3/5 14:27
 * @version v1.0
 * @Package com.logos.leetcode.hot100.normal_array
 */
public class Q01 {

    /**
     * 53. 最大子数组和
     */

    class Solution {
        public int maxSubArray(int[] nums) {
            int pre = nums[0];
            int ans = pre;
            for (int i = 1; i < nums.length; i++) {
                pre = Math.max(nums[i], pre + nums[i]);
                ans = Math.max(ans, pre);
            }
            return ans;
        }
    }

}
