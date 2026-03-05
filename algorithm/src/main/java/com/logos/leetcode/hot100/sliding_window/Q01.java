package com.logos.leetcode.hot100.sliding_window;

/**
 * @author logos
 * date 2026/3/4 22:23
 * @version v1.0
 * @Package com.logos.leetcode.hot100.sliding_window
 */
public class Q01 {

    /**
     * 3. 无重复字符的最长子串
     */

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] map = new char[256];
            int ans = 0;
            int left = 0;
            char[] sArr = s.toCharArray();
            for (int i = 0; i < sArr.length; i++) {
                map[sArr[i]]++;
                while (map[sArr[i]] > 1) {
                    map[sArr[left++]]--;
                }
                ans = Math.max(ans, i - left + 1);
            }
            return ans;
        }
    }

}
