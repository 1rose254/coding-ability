package com.logos.leetcode.hot100.normal_array;

/**
 * @author logos
 * date 2026/3/5 14:48
 * @version v1.0
 * @Package com.logos.leetcode.hot100.normal_array
 */
public class Q05 {

    /**
     * 41. 缺失的第一个正数
     */

    class Solution {
        public int firstMissingPositive(int[] nums) {
            int l = 0;
            int r = nums.length;
            while (l < r) {
                if (nums[l] == l + 1) {
                    l++;
                } else if (nums[l] <= l || nums[l] > r || nums[nums[l] - 1] == nums[l]) {
                    swap(nums, l, --r);
                } else {
                    swap(nums, l, nums[l] - 1);
                }
            }
            return l + 1;
        }

        private void swap(int[] nums, int l, int r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }

}
