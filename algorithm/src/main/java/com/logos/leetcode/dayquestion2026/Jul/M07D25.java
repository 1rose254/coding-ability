package com.logos.leetcode.dayquestion2026.Jul;

/**
 * @author logos
 * date 2026/7/24 21:34
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D25 {
    /**
     * 3536. 两个数字的最大乘积
     * <a href="https://leetcode.cn/problems/maximum-product-of-two-digits/description/"/>
     */

    class Solution {
        public int maxProduct(int n) {
            int mx = 0;
            int mx2 = 0;
            while (n > 0) {
                int d = n % 10;
                if (d > mx) {
                    mx2 = mx;
                    mx = d;
                } else if (d > mx2) {
                    mx2 = d;
                }
                n /= 10;
            }
            return mx * mx2;
        }
    }

}
