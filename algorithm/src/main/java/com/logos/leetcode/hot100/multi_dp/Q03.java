package com.logos.leetcode.hot100.multi_dp;

/**
 * @author logos
 * date 2026/3/16 20:20
 * @version v1.0
 * @Package com.logos.leetcode.hot100.multi_dp
 */
public class Q03 {

    /**
     * 5. 最长回文子串
     */

    class Solution {
        public String longestPalindrome(String s) {
            char[] sArr = s.toCharArray();
            int n = sArr.length;
            int ansLeft = 0;
            int ansRight = 0;
            for (int i = 0; i < 2 * n - 1; i++) {
                int l = i / 2;
                int r = (i + 1) / 2;
                while (l >= 0 && r < n && sArr[l] == sArr[r]) {
                    l--;
                    r++;
                }
                if (r - l - 1 > ansRight - ansLeft) {
                    ansLeft = l + 1;
                    ansRight = r;
                }
            }
            return s.substring(ansLeft, ansRight);
        }
    }

}
