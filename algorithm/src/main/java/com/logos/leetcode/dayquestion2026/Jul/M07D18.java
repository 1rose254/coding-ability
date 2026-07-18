package com.logos.leetcode.dayquestion2026.Jul;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/7/17 23:09
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D18 {

    /**
     * 1979. 找出数组的最大公约数
     * <a href="https://leetcode.cn/problems/find-greatest-common-divisor-of-array/description/"/>
     */

    class Solution {
        public int findGCD(int[] nums) {
            int mn = Arrays.stream(nums).min().getAsInt();
            int mx = Arrays.stream(nums).max().getAsInt();
            return gcd(mn, mx);
        }

        private int gcd(int a, int b) {
            while (a != 0) {
                int tmp = a;
                a = b % a;
                b = tmp;
            }
            return b;
        }
    }

}
