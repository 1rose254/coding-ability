package com.logos.leetcode.dayquestion2026.Jun;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/6/23 21:01
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D23 {

    /**
     * 3699. 锯齿形数组的总数 I
     * <a href="https://leetcode.cn/problems/number-of-zigzag-arrays-i/description/"/>
     */

    class Solution {
        public int zigZagArrays(int n, int l, int r) {
            final int MOD = 1_000_000_007;
            int k = r - l + 1;
            int[] f0 = new int[k];
            int[] f1 = new int[k];
            Arrays.fill(f0, 1);
            Arrays.fill(f1, 1);
            long[] s0 = new long[k + 1];
            long[] s1 = new long[k + 1];

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < k; j++) {
                    s0[j + 1] = s0[j] + f0[j];
                    s1[j + 1] = s1[j] + f1[j];
                }
                for (int j = 0; j < k; j++) {
                    f0[j] = (int) (s1[j] % MOD);
                    f1[j] = (int) ((s0[k] - s0[j + 1]) % MOD);
                }
            }

            long ans = 0;
            for (int j = 0; j < k; j++) {
                ans += f0[j] + f1[j];
            }
            return (int) (ans % MOD);
        }
    }

}
