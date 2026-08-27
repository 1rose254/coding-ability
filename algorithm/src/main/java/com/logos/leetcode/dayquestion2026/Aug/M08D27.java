package com.logos.leetcode.dayquestion2026.Aug;

/**
 * @author logos
 * date 2026/8/27 9:53
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D27 {

    /**
     * 3720. 大于目标字符串的最小字典序排列
     * <a href="https://leetcode.cn/problems/lexicographically-smallest-permutation-greater-than-target/description/"/>
     */

    class Solution {
        public String lexGreaterPermutation(String s, String target) {
            char[] t = target.toCharArray();
            int n = t.length;
            int[] left = new int[26];
            for (int i = 0; i < n; i++) {
                left[s.charAt(i) - 'a']++;
                left[t[i] - 'a']--;
            }
            int neg = 0;
            int mx = 0;
            for (int i = 0; i < 26; i++) {
                if (left[i] < 0) {
                    neg++;
                } else if (left[i] > 0) {
                    mx = Math.max(mx, i);
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                int b = t[i] - 'a';
                left[b]++;
                if (left[b] == 0) {
                    neg--;
                } else if (left[b] == 1) {
                    mx = Math.max(mx, b);
                }
                if (neg > 0 || b >= mx) {
                    continue;
                }
                int j = b + 1;
                while (left[j] == 0) {
                    j++;
                }
                left[j]--;
                StringBuilder ans = new StringBuilder(target.substring(0, i + 1));
                ans.setCharAt(i, (char) ('a' + j));
                for (int k = 0; k < 26; k++) {
                    ans.repeat('a' + k, left[k]);
                }
                return ans.toString();
            }
            return "";
        }
    }

}
