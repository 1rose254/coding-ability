package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/12 10:56
 * @version v1.0
 */
public class M11D12 {

    /**
     * 3105. 最长的严格递增或递减子数组
     * <a href="https://leetcode.cn/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/"/>
     */

    class Solution {
        public int longestMonotonicSubarray(int[] a) {
            int ans = 1;
            int i = 0, n = a.length;
            while (i < n - 1) {
                if (a[i + 1] == a[i]) {
                    i++;
                    continue;
                }
                int start = i;
                boolean inc = a[i] < a[i + 1];
                i += 2;
                while (i < n && a[i] != a[i - 1] && (a[i] > a[i - 1]) == inc) {
                    i++;
                }
                ans = Math.max(ans, i - start);
                i--;
            }
            return ans;
        }
    }

}
