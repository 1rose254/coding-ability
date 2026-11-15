package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/15 12:24
 * @version v1.0
 */
public class M11D15 {

    /**
     * 1524. 和为奇数的子数组数目
     * <a href="https://leetcode.cn/problems/number-of-sub-arrays-with-odd-sum/description/"/>
     */

    class Solution {
        public int numOfSubarrays(int[] arr) {
            final int MOD = 1_000_000_007;
            int[] cnt = {1, 0};
            int s = 0;
            long ans = 0;
            for (int x : arr) {
                s = (s + x) & 1;
                ans += cnt[s ^ 1];
                cnt[s]++;
            }
            return (int) (ans % MOD);
        }
    }

}
