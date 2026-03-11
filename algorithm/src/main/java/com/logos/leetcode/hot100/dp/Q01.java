package com.logos.leetcode.hot100.dp;

/**
 * @author logos
 * date 2026/3/11 16:50
 * @version v1.0
 * @Package com.logos.leetcode.hot100.dp
 */
public class Q01 {


    /**
     * 70. 爬楼梯
     */

    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int a = 1;
            int b = 2;
            int c = 0;
            for (int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

}
