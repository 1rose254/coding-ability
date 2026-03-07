package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/7 10:02
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D07 {

    /**
     * 1888. 使二进制字符串字符交替的最少反转次数
     * <a href="https://leetcode.cn/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/description/"/>
     */

    class Solution {
        public int minFlips(String S) {
            char[] s = S.toCharArray();
            int n = s.length;
            int ans = n;
            int cnt = 0;
            for (int i = 0; i < n * 2 - 1; i++) {
                if (s[i % n] % 2 != i % 2) {
                    cnt++;
                }
                int left = i - n + 1;
                if (left < 0) {
                    continue;
                }
                ans = Math.min(ans, Math.min(cnt, n - cnt));
                if (s[left] % 2 != left % 2) {
                    cnt--;
                }
            }
            return ans;
        }
    }

}
