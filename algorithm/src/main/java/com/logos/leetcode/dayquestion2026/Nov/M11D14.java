package com.logos.leetcode.dayquestion2026.Nov;

import java.util.List;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/14 14:55
 * @version v1.0
 */
public class M11D14 {

    /**
     * 3364. 最小正和子数组
     * <a href="https://leetcode.cn/problems/minimum-positive-sum-subarray/description/"/>
     */

    class Solution {
        public int minimumSumSubarray(List<Integer> nums, int l, int r) {
            Integer[] a = nums.toArray(Integer[]::new);
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i <= a.length - l; i++) {
                int s = 0;
                for (int j = i; j < a.length && j - i + 1 <= r; j++) {
                    s += a[j];
                    if (s > 0 && j - i + 1 >= l) {
                        ans = Math.min(ans, s);
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }

}
