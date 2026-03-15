package com.logos.leetcode.hot100.dp;

/**
 * @author logos
 * date 2026/3/15 16:55
 * @version v1.0
 * @Package com.logos.leetcode.hot100.dp
 */
public class Q08 {

    /**
     * 152. 乘积最大子数组
     */

    class Solution {
        public int maxProduct(int[] nums) {
            int ans = Integer.MIN_VALUE;
            int fmax = 1;
            int fmin = 1;
            for (int x : nums) {
                int mx = fmax;
                fmax = Math.max(Math.max(fmax * x, fmin * x), x);
                fmin = Math.min(Math.min(mx * x, fmin * x), x);
                ans = Math.max(ans, fmax);
            }
            return ans;
        }
    }

}
