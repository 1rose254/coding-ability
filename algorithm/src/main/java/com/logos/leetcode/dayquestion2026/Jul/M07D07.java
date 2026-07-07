package com.logos.leetcode.dayquestion2026.Jul;

/**
 * @author logos
 * date 2026/7/7 21:05
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D07 {

    /**
     * 3754. 连接非零数字并乘以其数字和 I
     * <a href="https://leetcode.cn/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/"/>
     */

    class Solution {
        public long sumAndMultiply(int n) {
            int x = 0;
            int sum = 0;
            for (int pow10 = 1; n > 0; n /= 10) {
                int d = n % 10;
                if (d > 0) {
                    x += d * pow10;
                    sum += d;
                    pow10 *= 10;
                }
            }
            return (long) x * sum;
        }
    }

}
