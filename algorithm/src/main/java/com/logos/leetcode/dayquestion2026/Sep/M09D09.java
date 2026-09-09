package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @author logos
 * date 2026/9/9 10:14
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Sep
 */
public class M09D09 {

    /**
     * 3871. 统计范围内的逗号 II
     * <a href="https://leetcode.cn/problems/count-commas-in-range-ii/description/"/>
     */

    class Solution {
        public long countCommas(long n) {
            long ans = 0;
            for (long low = 1000; low <= n; low *= 1000) {
                ans += n - low + 1;
            }
            return ans;
        }
    }
}
