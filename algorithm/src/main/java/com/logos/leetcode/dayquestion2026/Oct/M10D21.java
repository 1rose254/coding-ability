package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/21 10:11
 * @version v1.0
 */
public class M10D21 {

    /**
     * 3863. 将一个字符串排序的最小操作次数
     * <a href="https://leetcode.cn/problems/minimum-operations-to-sort-a-string/description/"/>
     */

    class Solution {
        public int minOperations(String S) {
            char[] s = S.toCharArray();
            int n = s.length;
            boolean isSorted = true;
            for (int i = 1; i < n; i++) {
                if (s[i - 1] > s[i]) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted) {
                return 0;
            }

            if (n == 2) {
                return -1;
            }
            char mn = s[0];
            char mx = s[0];
            for (char ch : s) {
                mn = (char) Math.min(mn, ch);
                mx = (char) Math.max(mx, ch);
            }
            if (s[0] == mn || s[n - 1] == mx) {
                return 1;
            }
            for (int i = 1; i < n - 1; i++) {
                if (s[i] == mn || s[i] == mx) {
                    return 2;
                }
            }
            return 3;
        }
    }

}
