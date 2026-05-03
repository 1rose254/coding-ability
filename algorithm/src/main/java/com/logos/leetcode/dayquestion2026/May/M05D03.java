package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/3 9:55
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D03 {

    /**
     * 796. 旋转字符串
     * <a href="https://leetcode.cn/problems/rotate-string/description/"/>
     */

    class Solution {
        public boolean rotateString(String s, String goal) {
            return s.length() == goal.length() && (s + s).contains(goal);
        }
    }

}
