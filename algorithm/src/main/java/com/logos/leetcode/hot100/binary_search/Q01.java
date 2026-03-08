package com.logos.leetcode.hot100.binary_search;

/**
 * @author logos
 * date 2026/3/8 15:29
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_search
 */
public class Q01 {

    /**
     * 35. 搜索插入位置
     */

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int n = nums.length;
            int l = 0;
            int r = n - 1;
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
