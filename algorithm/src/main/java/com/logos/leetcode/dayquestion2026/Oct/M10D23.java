package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/23 10:09
 * @version v1.0
 */
public class M10D23 {

    /**
     * 3644. 排序排列
     * <a href="https://leetcode.cn/problems/maximum-k-to-sort-a-permutation/description/"/>
     */

    class Solution {
        public int sortPermutation(int[] nums) {
            int ans = -1;
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                if (i != x) {
                    ans &= x;
                }
            }
            return Math.max(ans, 0);
        }
    }

}
