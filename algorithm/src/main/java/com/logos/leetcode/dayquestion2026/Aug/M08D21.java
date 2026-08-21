package com.logos.leetcode.dayquestion2026.Aug;


/**
 * @author logos
 * date 2026/8/21 9:54
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D21 {

    /**
     * 3116. 单面值组合的第 K 小金额
     * <a href="https://leetcode.cn/problems/kth-smallest-amount-with-single-denomination-combination/description/"/>
     */

    class Solution {
        public long findKthSmallest(int[] coins, int k) {
            int mn = Integer.MAX_VALUE;
            for (int x : coins) {
                mn = Math.min(mn, x);
            }
            long left = k - 1;
            long right = (long) mn * k;
            while (left + 1 < right) {
                long mid = left + (right - left) / 2;
                if (check(mid, coins, k)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }

        private boolean check(long m, int[] coins, int k) {
            long cnt = 0;
            next:
            for (int i = 1; i < (1 << coins.length); i++) {
                long lcmRes = 1;
                for (int j = 0; j < coins.length; j++) {
                    if ((i >> j & 1) == 1) {
                        lcmRes = lcm(lcmRes, coins[j]);
                        if (lcmRes > m) {
                            continue next;
                        }
                    }
                }
                cnt += Integer.bitCount(i) % 2 == 1 ? m / lcmRes : -m / lcmRes;
            }
            return cnt >= k;
        }

        private long gcd(long a, long b) {
            while (a != 0) {
                long tmp = a;
                a = b % a;
                b = tmp;
            }
            return b;
        }

        private long lcm(long a, long b) {
            return a / gcd(a, b) * b;
        }
    }

}
