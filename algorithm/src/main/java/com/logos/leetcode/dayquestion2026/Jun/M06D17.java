package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/17 21:40
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D17 {

    /**
     * 3614. 用特殊操作处理字符串 II
     * <a href="https://leetcode.cn/problems/process-string-with-special-operations-ii/description/"/>
     */

    class Solution {
        char processStr(String S, long k) {
            char[] s = S.toCharArray();
            int n = s.length;
            long[] size = new long[n];
            long sz = 0;
            for (int i = 0; i < n; i++) {
                char c = s[i];
                if (c == '*') {
                    sz = Math.max(sz - 1, 0);
                } else if (c == '#') {
                    sz *= 2;
                } else if (c != '%') {
                    sz++;
                }
                size[i] = sz;
            }

            if (k >= size[n - 1]) {
                return '.';
            }

            for (int i = n - 1;; i--) {
                char c = s[i];
                sz = size[i];
                if (c == '#') {
                    if (k >= sz / 2) {
                        k -= sz / 2;
                    }
                } else if (c == '%') {
                    k = sz - 1 - k;
                } else if (c != '*' && k == sz - 1) {
                    return c;
                }
            }
        }
    }

}
