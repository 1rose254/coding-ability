package com.logos.leetcode.hot100.binary_search;

/**
 * @author logos
 * date 2026/3/9 15:47
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_search
 */
public class Q05 {

    /**
     * 153. 寻找旋转排序数组中的最小值
     */

    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            int l = 0;
            int r = n - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < nums[r]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return nums[l];
        }
    }

}
