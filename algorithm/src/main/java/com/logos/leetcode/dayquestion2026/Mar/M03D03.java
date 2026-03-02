package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/2 23:56
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D03 {

    /**
     * 1545. 找出第 N 个二进制字符串中的第 K 位
     * <a href="https://leetcode.cn/problems/find-kth-bit-in-nth-binary-string/description/"/>
     * 今天回学校，寒假两个月好快结束了
     */

    class Solution {
        public char findKthBit(int n, int k) {
            if (n == 1) {
                return '0';
            }
            if (k == 1 << (n - 1)) {
                return '1';
            }
            if (k < 1 << (n - 1)) {
                return findKthBit(n - 1, k);
            }
            char res = findKthBit(n - 1, (1 << n) - k);
            return (char) (res ^ 1);
        }
    }

}
