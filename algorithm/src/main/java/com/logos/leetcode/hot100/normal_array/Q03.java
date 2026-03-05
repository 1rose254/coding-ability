package com.logos.leetcode.hot100.normal_array;

/**
 * @author logos
 * date 2026/3/5 14:41
 * @version v1.0
 * @Package com.logos.leetcode.hot100.normal_array
 */
public class Q03 {

    /**
     * 189. 轮转数组
     */

    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int left, int right) {
            while (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
    }

}
