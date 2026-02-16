package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/16 18:53
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D16 {

    /**
     * 190. 颠倒二进制位
     * <a href="https://leetcode.cn/problems/reverse-bits/description/"/>
     */

    public class Solution {
        public int reverseBits(int n) {
            n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
            n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
            n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
            n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
            n = (n >>> 16) | (n << 16);
            return n;
        }
    }

}
