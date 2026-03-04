package com.logos.leetcode.hot100.double_pointer;

/**
 * @author logos
 * date 2026/3/4 21:50
 * @version v1.0
 * @Package com.logos.leetcode.hot100.double_pointer
 */
public class Q02 {

    /**
     * 11. 盛最多水的容器
     */

    class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int l = 0;
            int r = n - 1;
            int ans = 0;
            while (l <= r) {
                int h = Math.min(height[l], height[r]);
                ans = Math.max(ans, h * (r - l));
                while (l <= r && height[l] <= h) {
                    l++;
                }
                while (l <= r && height[r] <= h) {
                    r--;
                }
            }
            return ans;
        }
    }

}
