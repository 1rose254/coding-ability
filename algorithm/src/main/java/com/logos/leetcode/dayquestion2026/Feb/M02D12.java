package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/12 9:09
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D12 {


    /**
     * 3713. 最长的平衡子串 I
     * <a href="https://leetcode.cn/problems/longest-balanced-substring-i/description/"/>
     */
    class Solution {
        public int longestBalanced(String s) {
            char[] arr = s.toCharArray();
            int n = s.length();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int[] cnt = new int[26];
                int max = 0;
                int dif = 0;
                for (int j = i; j < n; j++) {
                    max = Math.max(max, ++cnt[arr[j] - 'a']);
                    if (cnt[arr[j] - 'a'] == 1) {
                        dif++;
                    }
                    if (max * dif == j - i + 1) {
                        ans = Math.max(j - i + 1, ans);
                    }
                }
            }
            return ans;
        }
    }

}
