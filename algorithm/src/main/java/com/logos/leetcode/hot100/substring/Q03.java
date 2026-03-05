package com.logos.leetcode.hot100.substring;

/**
 * @author logos
 * date 2026/3/5 14:26
 * @version v1.0
 * @Package com.logos.leetcode.hot100.substring
 */
public class Q03 {

    /**
     * 76. 最小覆盖子串
     */

    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();
            int[] cnt = new int[256];
            int dept = tArr.length;
            int start = 0;
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < tArr.length; i++) {
                cnt[tArr[i]]--;
            }
            for (int l = 0, r = 0; r < sArr.length; r++) {
                if (cnt[sArr[r]]++ < 0) {
                    dept--;
                }
                if (dept == 0) {
                    while (cnt[sArr[l]] > 0) {
                        cnt[sArr[l++]]--;
                    }
                    if (ans > r - l + 1) {
                        ans = r - l + 1;
                        start = l;
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? "" : s.substring(start, start + ans);
        }
    }

}
