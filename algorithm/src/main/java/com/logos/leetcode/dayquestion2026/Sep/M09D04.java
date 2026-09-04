package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @author logos
 * date 2026/9/4 10:25
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Sep
 */
public class M09D04 {

    /**
     * 3903. 最小稳定下标 I
     * <a href="https://leetcode.cn/problems/smallest-stable-index-i/description/"/>
     */

    class Solution {
        public int firstStableIndex(int[] nums, int k) {
            int n = nums.length;
            int[] sufMin = new int[n];
            sufMin[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                sufMin[i] = Math.min(sufMin[i + 1], nums[i]);
            }
            int preMax = 0;
            for (int i = 0; i < n; i++) {
                preMax = Math.max(preMax, nums[i]);
                if (preMax - sufMin[i] <= k) {
                    return i;
                }
            }
            return -1;
        }
    }

}
