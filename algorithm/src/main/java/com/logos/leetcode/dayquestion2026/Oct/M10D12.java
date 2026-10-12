package com.logos.leetcode.dayquestion2026.Oct;

import java.util.List;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/12 11:26
 * @version v1.0
 */
public class M10D12 {

    /**
     * 2897. 对数组执行操作使平方和最大
     * <a href="https://leetcode.cn/problems/apply-operations-on-array-to-maximize-sum-of-squares/description/"/>
     */

    class Solution {
        public int maxSum(List<Integer> nums, int k) {
            final long MOD = 1_000_000_007;
            int[] cnt = new int[30];
            for (int x : nums) {
                for (int i = 0; i < 30; i++) {
                    cnt[i] += (x >> i) & 1;
                }
            }
            long ans = 0;
            while (k-- > 0) {
                int x = 0;
                for (int i = 0; i < 30; i++) {
                    if (cnt[i] > 0) {
                        cnt[i]--;
                        x |= 1 << i;
                    }
                }
                ans = (ans + (long) x * x) % MOD;
            }
            return (int) ans;
        }
    }

}
