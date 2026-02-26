package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/27 0:01
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D27 {

    /**
     * 3666. 使二进制字符串全为 1 的最少操作次数
     * <a href="https://leetcode.cn/problems/minimum-operations-to-equalize-binary-string/description/"/>
     */

    class Solution {
        public int minOperations(String s, int k) {
            int n = s.length();
            int z = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    z++;
                }
            }
            if (z == 0) {
                return 0;
            }
            if (k == n) {
                return z == n ? 1 : -1;
            }
            int ans = Integer.MAX_VALUE;
            if (z % 2 == 0) {
                int m = Math.max((z + k - 1) / k, (z + n - k - 1) / (n - k));
                ans = m + m % 2;
            }
            if (z % 2 == k % 2) {
                int m = Math.max((z + k - 1) / k, (n - z + n - k - 1) / (n - k));
                ans = Math.min(ans, m | 1);
            }
            return ans < Integer.MAX_VALUE ? ans : -1;
        }
    }

}
