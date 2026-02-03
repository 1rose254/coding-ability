package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/4 0:14
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D04 {

    /**
     * 3640. 三段式数组 II
     * <a href="https://leetcode.cn/problems/trionic-array-ii/description/"/>
     */

    class Solution {
        public long maxSumTrionic(int[] nums) {
            final long NEG_INF = Long.MIN_VALUE / 2;
            long ans = NEG_INF;
            long f1 = NEG_INF;
            long f2 = NEG_INF;
            long f3 = NEG_INF;
            for (int i = 1; i < nums.length; i++) {
                int x = nums[i - 1];
                int y = nums[i];
                f3 = x < y ? Math.max(f3, f2) + y : NEG_INF;
                f2 = x > y ? Math.max(f2, f1) + y : NEG_INF;
                f1 = x < y ? Math.max(f1, x) + y : NEG_INF;
                ans = Math.max(ans, f3);
            }
            return ans;
        }
    }

}
