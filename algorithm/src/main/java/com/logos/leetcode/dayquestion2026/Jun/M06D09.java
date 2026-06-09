package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/9 9:14
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D09 {

    /**
     * 3689. 最大子数组总值 I
     * <a href="https://leetcode.cn/problems/maximum-total-subarray-value-i/description/"/>
     */

    class Solution {
        public long maxTotalValue(int[] nums, int k) {
            int mn = Integer.MAX_VALUE;
            int mx = 0;
            for (int x : nums) {
                mn = Math.min(mn, x);
                mx = Math.max(mx, x);
            }
            return (long) (mx - mn) * k;
        }
    }

}
