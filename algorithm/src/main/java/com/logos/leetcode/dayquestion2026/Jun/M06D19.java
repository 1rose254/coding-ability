package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/19 10:29
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D19 {

    /**
     * 1732. 找到最高海拔
     * <a href="https://leetcode.cn/problems/find-the-highest-altitude/description/"/>
     */

    class Solution {
        public int largestAltitude(int[] gain) {
            int ans = 0;
            int h = 0;
            for (int d : gain) {
                h += d;
                ans = Math.max(ans, h);
            }
            return ans;
        }
    }

}
