package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/23 14:49
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D23 {

    /**
     * 1752. 检查数组是否经排序和轮转得到
     * <a href="https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/description/"/>
     */

    class Solution {
        public boolean check(int[] nums) {
            int n = nums.length;
            boolean sorted = true;
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] > nums[i]) {
                    if (!sorted) {
                        return false;
                    }
                    sorted = false;
                }
            }
            return sorted || nums[0] >= nums[n - 1];
        }
    }

}
