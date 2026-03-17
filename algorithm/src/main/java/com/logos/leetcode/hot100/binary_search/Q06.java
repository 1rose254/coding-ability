package com.logos.leetcode.hot100.binary_search;

/**
 * @author logos
 * date 2026/3/9 16:01
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_search
 */
public class Q06 {

    /**
     * 4. 寻找两个正序数组的中位数
     */

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int totalN = n + m;
            if (totalN % 2 == 1) {
                int mid = totalN / 2;
                double ans = getKthElement(nums1, nums2, mid + 1);
                return ans;
            } else {
                int mid = totalN / 2;
                double ans = (getKthElement(nums1, nums2, mid) + getKthElement(nums1, nums2, mid + 1)) / 2.0;
                return ans;
            }
        }

        private int getKthElement(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;
            int m = nums2.length;
            int index1 = 0;
            int index2 = 0;
            int kthElement = 0;
            while (true) {
                if (index1 == n) {
                    return nums2[index2 + k - 1];
                }
                if (index2 == m) {
                    return nums1[index1 + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }
                int half = k / 2;
                int newIndex1 = Math.min(index1 + half, n) - 1;
                int newIndex2 = Math.min(index2 + half, m) - 1;
                int pivot1 = nums1[newIndex1];
                int pivot2 = nums2[newIndex2];
                if (pivot1 <= pivot2) {
                    k -= (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                } else {
                    k -= (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
    }

}
