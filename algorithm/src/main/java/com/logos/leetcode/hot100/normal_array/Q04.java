package com.logos.leetcode.hot100.normal_array;

/**
 * @author logos
 * date 2026/3/5 14:48
 * @version v1.0
 * @Package com.logos.leetcode.hot100.normal_array
 */
public class Q04 {

    /**
     * 238. 除自身以外数组的乘积
     */

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            ans[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                ans[i] = ans[i + 1] * nums[i + 1];
            }
            int pre = 1;
            for (int i = 0; i < n; i++) {
                ans[i] *= pre;
                pre *= nums[i];
            }
            return ans;
        }
    }

}
