package com.logos.leetcode.dayquestion2026.Apr;

/**
 * @author logos
 * date 2026/4/19 9:57
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D19 {

    /**
     * 1855. 下标对中的最大距离
     * <a href="https://leetcode.cn/problems/maximum-distance-between-a-pair-of-values/description/"/>
     */

    class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int ans = 0;
            int i = 0;
            for (int j = 0; j < nums2.length; j++) {
                while (i < nums1.length && nums1[i] > nums2[j]) {
                    i++;
                }
                if (i == nums1.length) {
                    break;
                }
                ans = Math.max(ans, j - i);
            }
            return ans;
        }
    }

}
