package com.logos.leetcode.dayquestion2026.Aug;

/**
 * @author logos
 * date 2026/8/22 17:52
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D22 {

    /**
     * 3622. 判断整除性
     * <a href="https://leetcode.cn/problems/check-divisibility-by-digit-sum-and-product/description/"/>
     */

    class Solution {
        public boolean checkDivisibility(int n) {
            int s = 0, m = 1;
            for (int x = n; x > 0; x /= 10) {
                int d = x % 10;
                s += d;
                m *= d;
            }
            return n % (s + m) == 0;
        }
    }

}
