package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/11 8:08
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D11 {

    /**
     * 1009. 十进制整数的反码
     * <a href="https://leetcode.cn/problems/complement-of-base-10-integer/description/">
     */
    class Solution {
        public int bitwiseComplement(int n) {
            if (n == 0) {
                return 1;
            }
            int w = 32 - Integer.numberOfLeadingZeros(n);
            return ((1 << w) - 1) ^ n;
        }
    }

}
