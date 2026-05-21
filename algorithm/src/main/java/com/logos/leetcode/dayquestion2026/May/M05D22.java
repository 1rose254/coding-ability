package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/22 7:27
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D22 {

    /**
     * 33. 搜索旋转排序数组
     * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/description/"/>
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
