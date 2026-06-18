package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/18 20:55
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D18 {

    /**
     * 1344. 时钟指针的夹角
     * <a href="https://leetcode.cn/problems/angle-between-hands-of-a-clock/description/"/>
     */
    class Solution {
        public double angleClock(int hour, int minutes) {
            double d = Math.abs(hour * 30 - minutes * 5.5);
            return Math.min(d, 360 - d);
        }
    }

}
