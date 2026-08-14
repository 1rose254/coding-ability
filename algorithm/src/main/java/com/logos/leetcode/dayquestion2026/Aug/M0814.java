package com.logos.leetcode.dayquestion2026.Aug;

/**
 * @author logos
 * date 2026/8/14 19:39
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M0814 {

    /**
     * 3090. 每个字符最多出现两次的最长子字符串
     * <a href="https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/"/>
     */

    class Solution {
        public int maximumLengthSubstring(String S) {
            char[] s = S.toCharArray();
            int ans = 0;
            int left = 0;
            int[] cnt = new int[26];
            for (int i = 0; i < s.length; i++) {
                int b = s[i] - 'a';
                cnt[b]++;
                while (cnt[b] > 2) {
                    cnt[s[left] - 'a']--;
                    left++;
                }
                ans = Math.max(ans, i - left + 1);
            }
            return ans;
        }
    }

}
