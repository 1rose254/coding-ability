package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @author logos
 * date 2026/9/8 10:29
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Sep
 */
public class M09D08 {

    /**
     * 3870. 统计范围内的逗号
     * <a href="https://leetcode.cn/problems/count-commas-in-range/description/"/>
     */

    class Solution {
        public int countCommas(int n) {
            int ans = 0;
            for (int low = 1000; low <= n; low *= 1000) {
                ans += n - low + 1;
            }
            return ans;
        }
    }

}
