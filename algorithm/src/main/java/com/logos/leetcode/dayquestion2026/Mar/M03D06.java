package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/6 9:57
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D06 {

    /**
     * 1784. 检查二进制字符串字段
     * <a href="https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description/"/>
     */

    class Solution {
        public boolean checkOnesSegment(String s) {
            return !s.contains("01");
        }
    }

}
