package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/3 0:09
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D03 {

    /**
     * 3637. 三段式数组 I
     * <a href="https://leetcode.cn/problems/trionic-array-i/description/"/>
     */

    class Solution {
        public boolean isTrionic(int[] nums) {
            if (nums[0] >= nums[1]) {
                return false;
            }
            int cnt = 1;
            for (int i = 2; i < nums.length; i++) {
                if (nums[i - 1] == nums[i]) {
                    return false;
                }
                if ((nums[i - 2] < nums[i - 1]) != (nums[i - 1] < nums[i])) {
                    cnt++;
                }
            }
            return cnt == 3;
        }
    }

}
