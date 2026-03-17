package com.logos.leetcode.hot100.skill;

/**
 * @author logos
 * date 2026/3/16 20:46
 * @version v1.0
 * @Package com.logos.leetcode.hot100.skill
 */
public class Q04 {

    /**
     * 31. 下一个排列
     */

    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = n - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1, n - 1);
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        private void reverse(int[] nums, int left, int right) {
            while (left < right) {
                swap(nums, left++, right--);
            }
        }
    }

}
