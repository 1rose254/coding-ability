package com.logos.leetcode.hot100.double_pointer;

/**
 * @author logos
 * date 2026/3/4 21:46
 * @version v1.0
 * @Package com.logos.leetcode.hot100.double_pointer
 */
public class Q01 {

    /**
     * 283. 移动零
     */

    class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                if (nums[right] != 0) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                }
            }
        }
    }

}
