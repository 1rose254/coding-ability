package com.logos.leetcode.dayquestion2026.Apr;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/4/25 10:47
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D25 {

    /**
     * 3464. 正方形上的点之间的最大距离
     * <a href="https://leetcode.cn/problems/maximize-the-distance-between-points-on-a-square/description/"/>
     */

    class Solution {
        public int maxDistance(int side, int[][] points, int k) {
            long[] a = new long[points.length];
            for (int i = 0; i < points.length; i++) {
                int x = points[i][0];
                int y = points[i][1];
                if (x == 0) {
                    a[i] = y;
                } else if (y == side) {
                    a[i] = side + x;
                } else if (x == side) {
                    a[i] = side * 3L - y;
                } else {
                    a[i] = side * 4L - x;
                }
            }
            Arrays.sort(a);

            int left = 1;
            int right = (int) (side * 4L / k) + 1;
            while (left + 1 < right) {
                int mid = (left + right) >>> 1;
                if (check(a, side, k, mid)) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        private boolean check(long[] a, int side, int k, int low) {
            next: for (long start : a) {
                long end = start + side * 4L - low;
                long cur = start;
                for (int i = 0; i < k - 1; i++) {
                    int j = lowerBound(a, cur + low);
                    if (j == a.length || a[j] > end) {
                        continue next;
                    }
                    cur = a[j];
                }
                return true;
            }
            return false;
        }

        private int lowerBound(long[] nums, long target) {
            int left = -1;
            int right = nums.length;
            while (left + 1 < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }
    }

}
