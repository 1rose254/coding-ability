package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/7 9:52
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D07 {

    /**
     * 3660. 跳跃游戏 IX
     * <a href="https://leetcode.cn/problems/jump-game-ix/description/"/>
     */

    class Solution {
        public int[] maxValue(int[] nums) {
            int n = nums.length;
            int[] preMax = new int[n];
            preMax[0] = nums[0];
            for (int i = 1; i < n; i++) {
                preMax[i] = Math.max(preMax[i - 1], nums[i]);
            }

            int sufMin = Integer.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                if (preMax[i] > sufMin) {
                    preMax[i] = preMax[i + 1];
                }
                sufMin = Math.min(sufMin, nums[i]);
            }
            return preMax;
        }
    }

}
