package com.logos.leetcode.dayquestion2026.Feb;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/2/6 14:03
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D06 {


    /**
     * 3634. 使数组平衡的最少移除数目
     * <a href="https://leetcode.cn/problems/minimum-removals-to-balance-array/description/"/>
     */

    class Solution {
        public int minRemoval(int[] nums, int k) {
            Arrays.sort(nums);
            int maxSave = 0;
            int left = 0;
            for (int i = 0; i < nums.length; i++) {
                while ((long) nums[left] * k < nums[i]) {
                    left++;
                }
                maxSave = Math.max(maxSave, i - left + 1);
            }
            return nums.length - maxSave;
        }
    }

}
