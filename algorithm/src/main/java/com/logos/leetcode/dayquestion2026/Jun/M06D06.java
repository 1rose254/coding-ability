package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/6 18:49
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D06 {

    /**
     * 2574. 左右元素和的差值
     * <a href="https://leetcode.cn/problems/left-and-right-sum-differences/description/"/>
     */

    class Solution {
        public int[] leftRightDifference(int[] nums) {
            int total = 0;
            for (int x : nums) {
                total += x;
            }

            int leftSum = 0;
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                nums[i] = Math.abs(leftSum * 2 + x - total);
                leftSum += x;
            }
            return nums;
        }
    }

}
