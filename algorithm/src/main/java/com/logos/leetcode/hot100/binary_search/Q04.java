package com.logos.leetcode.hot100.binary_search;

/**
 * @author logos
 * date 2026/3/9 15:46
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_search
 */
public class Q04 {

    /**
     * 33. 搜索旋转排序数组
     */

    class Solution {
        public int search(int[] nums, int target) {
            int mid = findMinIndex(nums, target);
            if (nums[mid] == target) {
                return mid;
            }
            int ans = binarySearch(nums, target, 0, mid - 1);
            return ans == -1 ? binarySearch(nums, target, mid + 1, nums.length - 1) : ans;
        }

        private int findMinIndex(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < nums[r]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        private int binarySearch(int[] nums, int target, int l, int r) {
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < target) {
                    l = mid + 1;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }

}
