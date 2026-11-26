package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/26 11:57
 * @version v1.0
 */
public class M11D26 {

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
