package com.logos.leetcode.dayquestion2026.Jul;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/7/6 20:59
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D06 {

    /**
     * 1288. 删除被覆盖区间
     * <a href="https://leetcode.cn/problems/remove-covered-intervals/description/"/>
     */

    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
            int ans = 0;
            int maxRight = 0;
            for (int[] p : intervals) {
                if (p[1] > maxRight) {
                    maxRight = p[1];
                    ans++;
                }
            }
            return ans;
        }
    }

}
