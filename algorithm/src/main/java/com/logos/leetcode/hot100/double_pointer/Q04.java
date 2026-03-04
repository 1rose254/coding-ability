package com.logos.leetcode.hot100.double_pointer;

/**
 * @author logos
 * date 2026/3/4 22:20
 * @version v1.0
 * @Package com.logos.leetcode.hot100.double_pointer
 */
public class Q04 {

    /**
     * 42. 接雨水
     */

    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int n = height.length;
            int l = 1;
            int r = n - 2;
            int lmax = height[0];
            int rmax = height[n - 1];
            while (l <= r) {
                if (lmax < rmax) {
                    ans += Math.max(0, lmax - height[l]);
                    lmax = Math.max(lmax, height[l]);
                    l++;
                } else {
                    ans += Math.max(0, rmax - height[r]);
                    rmax = Math.max(rmax, height[r]);
                    r--;
                }
            }
            return ans;
        }
    }

}
