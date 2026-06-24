package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/24 19:41
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D24 {

    /**
     * 3700. 锯齿形数组的总数 II
     * <a href="https://leetcode.cn/problems/number-of-zigzag-arrays-ii/description/"/>
     */

    class Solution {
        private static final int MOD = 1_000_000_007;

        public int zigZagArrays(int n, int l, int r) {
            int k = r - l + 1;
            long[][] m = new long[k][k];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k - 1 - i; j++) {
                    m[i][j] = 1;
                }
            }

            long[][] f1 = new long[k][1];
            for (int i = 0; i < k; i++) {
                f1[i][0] = 1;
            }

            long[][] fn = powMul(m, n - 1, f1);

            long ans = 0;
            for (long[] row : fn) {
                ans += row[0];
            }
            return (int) (ans * 2 % MOD);
        }

        private long[][] powMul(long[][] a, int n, long[][] f0) {
            long[][] res = f0;
            while (n > 0) {
                if ((n & 1) > 0) {
                    res = mul(a, res);
                }
                a = mul(a, a);
                n >>= 1;
            }
            return res;
        }

        private long[][] mul(long[][] a, long[][] b) {
            long[][] c = new long[a.length][b[0].length];
            for (int i = 0; i < a.length; i++) {
                for (int k = 0; k < a[i].length; k++) {
                    if (a[i][k] == 0) {
                        continue;
                    }
                    for (int j = 0; j < b[k].length; j++) {
                        c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
                    }
                }
            }
            return c;
        }
    }

}
