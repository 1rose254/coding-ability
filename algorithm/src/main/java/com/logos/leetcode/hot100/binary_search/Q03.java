package com.logos.leetcode.hot100.binary_search;

/**
 * @author logos
 * date 2026/3/9 15:41
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_search
 */
public class Q03 {

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     */

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int ans = binarySearch(nums, target);
            if (ans >= nums.length || nums[ans] != target) {
                return new int[] { -1, -1 };
            }
            return new int[] { ans, binarySearch(nums, target + 1) - 1 };
        }

        public int binarySearch(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }

}
