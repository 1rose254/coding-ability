package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/16 15:36
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D16 {

    /**
     * 154. 寻找旋转排序数组中的最小值 II
     * <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/description/"/>
     */

    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < nums[right]) {
                    right = mid;
                } else if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    --right;
                }
            }
            return nums[right];
        }
    }

}
