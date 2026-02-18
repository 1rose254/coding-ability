package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/18 12:31
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D18 {

    /**
     * 693. 交替位二进制数
     * <a href="https://leetcode.cn/problems/binary-number-with-alternating-bits/description/"/>
     */

    class Solution {
        public boolean hasAlternatingBits(int n) {
            int x = (n >> 1) ^ n;
            return ((x + 1) & x) == 0;
        }
    }

}
