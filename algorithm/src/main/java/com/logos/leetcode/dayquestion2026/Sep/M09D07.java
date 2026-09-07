package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @author logos
 * date 2026/9/7 10:10
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Sep
 */
public class M09D07 {

    /**
     * 940. 不同的子序列 II
     * <a href="https://leetcode.cn/problems/distinct-subsequences-ii/description/"/>
     */

    class Solution {
        private static final int MOD = 1000000007;

        public int distinctSubseqII(String s) {
            int[] cnt = new int[26];
            int all = 1;
            int newAdd = 0;
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                newAdd = (all - cnt[c - 'a'] + MOD) % MOD;
                cnt[c - 'a'] = (cnt[c - 'a'] + newAdd) % MOD;
                all = (newAdd + all) % MOD;
            }
            return (all - 1 + MOD) % MOD;
        }
    }

}
