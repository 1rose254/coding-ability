package com.logos.leetcode.dayquestion2026.Mar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/15 10:04
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D15 {

    /**
     * 1622. 奇妙序列
     * <a href="https://leetcode.cn/problems/fancy-sequence/description/"/>
     */

    class Fancy {
        private static final int MOD = 1_000_000_007;

        private final List<Integer> vals = new ArrayList<>();

        private long add = 0;

        private long mul = 1;

        public void append(int val) {
            vals.add((int) ((val - add + MOD) * pow(mul, MOD - 2) % MOD));
        }

        public void addAll(int inc) {
            add = (add + inc) % MOD;
        }

        public void multAll(int m) {
            mul = mul * m % MOD;
            add = add * m % MOD;
        }

        public int getIndex(int idx) {
            if (idx >= vals.size()) {
                return -1;
            }
            return (int) ((vals.get(idx) * mul + add) % MOD);
        }

        private long pow(long x, int n) {
            long res = 1;
            for (; n > 0; n /= 2) {
                if (n % 2 > 0) {
                    res = res * x % MOD;
                }
                x = x * x % MOD;
            }
            return res;
        }
    }

}
