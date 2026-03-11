package com.logos.leetcode.hot100.dp;

/**
 * @author logos
 * date 2026/3/11 16:54
 * @version v1.0
 * @Package com.logos.leetcode.hot100.dp
 */
public class Q03 {

    /**
     * 198. 打家劫舍
     */

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            int a = nums[0];
            int b = Math.max(a, nums[1]);
            int c = Math.max(a, b);
            for (int i = 2; i < n; i++) {
                c = Math.max(b, a + nums[i]);
                a = b;
                b = c;
            }
            return c;
        }
    }

}
