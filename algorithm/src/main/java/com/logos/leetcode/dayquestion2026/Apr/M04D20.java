package com.logos.leetcode.dayquestion2026.Apr;

/**
 * @author logos
 * date 2026/4/20 8:49
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D20 {

    /**
     * 2078. 两栋颜色不同且距离最远的房子
     * <a href="https://leetcode.cn/problems/two-furthest-houses-with-different-colors/description/"/>
     */

    class Solution {
        public int maxDistance(int[] colors) {
            int n = colors.length;
            int c = colors[0];
            if (c != colors[n - 1]) {
                return n - 1;
            }

            int r = n - 2;
            while (colors[r] == c) {
                r--;
            }

            int l = 1;
            while (colors[l] == c) {
                l++;
            }

            return Math.max(r, n - 1 - l);
        }
    }

}
