package com.logos.leetcode.dayquestion2026.Aug;

/**
 * @author logos
 * date 2026/8/6 19:40
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D06 {

    /**
     * 3345. 最小可整除数位乘积 I
     * <a href="https://leetcode.cn/problems/smallest-divisible-digit-product-i/description/"/>
     */

    class Solution {
        int smallestNumber(int n, int t) {
            for (int i = n; ; i++) {
                int prod = 1;
                for (int x = i; x > 0; x /= 10) {
                    prod *= x % 10;
                }
                if (prod % t == 0) {
                    return i;
                }
            }
        }
    }

}
