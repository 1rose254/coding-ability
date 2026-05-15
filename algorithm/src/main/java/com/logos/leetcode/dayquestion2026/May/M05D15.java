package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/15 10:11
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D15 {

    /**
     * 153. 寻找旋转排序数组中的最小值
     * <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/"/>
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
