package com.logos.leetcode.hot100.greedy_algorithm;

/**
 * @author logos
 * date 2026/3/10 10:26
 * @version v1.0
 * @Package com.logos.leetcode.hot100.greedy_algorithm
 */
public class Q02 {

    /**
     * 55. 跳跃游戏
     */

    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return true;
            }
            int cover = 0;
            for (int i = 0; i <= cover; i++) {
                cover = Math.max(cover, i + nums[i]);
                if (cover >= n - 1) {
                    return true;
                }
            }
            return false;
        }
    }

}
