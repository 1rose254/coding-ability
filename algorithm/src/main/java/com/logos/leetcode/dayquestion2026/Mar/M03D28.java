package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/28 23:14
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D28 {


    /**
     * 2573. 找出对应 LCP 矩阵的字符串
     * <a href="https://leetcode.cn/problems/find-the-string-with-lcp/"/>
     */

    class Solution {
        public String findTheString(int[][] lcp) {
            int n = lcp.length;
            char[] s = new char[n];
            int i = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        s[j] = c;
                    }
                }
                while (i < n && s[i] > 0) {
                    i++;
                }
                if (i == n) {
                    break;
                }
            }

            if (i < n) {
                return "";
            }

            for (i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int actualLcp = s[i] != s[j] ? 0 : (i == n - 1 || j == n - 1 ? 1 : lcp[i + 1][j + 1] + 1);
                    if (lcp[i][j] != actualLcp) {
                        return "";
                    }
                }
            }
            return new String(s);
        }
    }

}
