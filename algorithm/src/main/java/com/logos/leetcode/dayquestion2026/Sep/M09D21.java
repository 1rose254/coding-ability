package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/21 10:06
 * @version v1.0
 */
public class M09D21 {

    /**
     * 3524. 求出数组的 X 值 I
     * <a href="https://leetcode.cn/problems/find-x-value-of-array-i/description/"/>
     */

    class Solution {
        public long[] resultArray(int[] nums, int k) {
            long[] ans = new long[k];
            int[] f = new int[k];
            for (int v : nums) {
                v %= k;
                int[] nf = new int[k];
                nf[v] = 1;
                for (int y = 0; y < k; y++) {
                    nf[y * v % k] += f[y];
                }
                f = nf;
                for (int x = 0; x < k; x++) {
                    ans[x] += f[x];
                }
            }
            return ans;
        }
    }

}
