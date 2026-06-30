package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/30 19:54
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D30 {

    /**
     * 1358. 包含所有三种字符的子字符串数目
     * <a href="https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/description/"/>
     */

    class Solution {
        public int numberOfSubstrings(String S) {
            char[] s = S.toCharArray();
            int ans = 0;
            int left = 0;
            int[] cnt = new int[3];
            for (char c : s) {
                cnt[c - 'a']++;
                while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                    cnt[s[left] - 'a']--;
                    left++;
                }
                ans += left;
            }
            return ans;
        }
    }

}
