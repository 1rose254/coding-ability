package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/20 8:00
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D20 {

    /**
     * 2657. 找到两个数组的前缀公共数组
     * <a href="https://leetcode.cn/problems/find-the-prefix-common-array-of-two-arrays/description/"/>
     */

    class Solution {
        public int[] findThePrefixCommonArray(int[] a, int[] b) {
            long p = 0, q = 0;
            for (int i = 0; i < a.length; i++) {
                p |= 1L << a[i];
                q |= 1L << b[i];
                a[i] = Long.bitCount(p & q);
            }
            return a;
        }
    }

}
