package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/28 0:08
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D28 {

    /**
     * 1680. 连接连续二进制数字
     * <a href="https://leetcode.cn/problems/concatenation-of-consecutive-binary-numbers/description/"/>
     */

    public class Solution {
        private static final int MOD = 1000000007;

        public int concatenatedBinary(int n) {
            int res = 0, shift = 0;
            for (int i = 1; i <= n; i++) {
                if ((i & (i - 1)) == 0) {
                    shift++;
                }
                res = (int) ((((long) res << shift) + i) % MOD);
            }
            return res;
        }
    }

}
