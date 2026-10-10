package com.logos.leetcode.dayquestion2026.Oct;

import java.util.Arrays;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/10 10:35
 * @version v1.0
 */
public class M10D10 {

    /**
     * 2333. 最小差值平方和
     * <a href="https://leetcode.cn/problems/minimum-sum-of-squared-difference/description/"/>
     */

    class Solution {
        public long minSumSquareDiff(int[] a, int[] nums2, int k1, int k2) {
            int n = a.length;
            int k = k1 + k2;
            long ans = 0;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Math.abs(a[i] - nums2[i]);
                sum += a[i];
                ans += (long) a[i] * a[i];
            }
            if (sum <= k) {
                return 0;
            }
            Arrays.sort(a);
            for (int i = n - 1; ; i--) {
                int m = n - i;
                long v = a[i];
                long c = m * (v - (i > 0 ? a[i - 1] : 0));
                ans -= v * v;
                if (c < k) {
                    k -= c;
                    continue;
                }
                v -= k / m;
                return ans + k % m * (v - 1) * (v - 1) + (m - k % m) * v * v;
            }
        }
    }

}
