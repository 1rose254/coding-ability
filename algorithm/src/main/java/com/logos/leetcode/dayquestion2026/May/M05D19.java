package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/19 8:06
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D19 {

    /**
     * 2540. 最小公共值
     * <a href="https://leetcode.cn/problems/minimum-common-value/description/"/>
     */

    class Solution {
        public int getCommon(int[] nums1, int[] nums2) {
            int i = 0;
            int n = nums1.length;
            int j = 0;
            int m = nums2.length;
            while (i < n && j < m) {
                if (nums1[i] == nums2[j]) {
                    return nums1[i];
                }
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            return -1;
        }
    }

}
