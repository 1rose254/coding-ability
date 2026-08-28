package com.logos.leetcode.dayquestion2026.Aug;

/**
 * @author logos
 * date 2026/8/28 10:04
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D28 {

    /**
     * 3734. 大于目标字符串的最小字典序回文排列
     * <a href="https://leetcode.cn/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/description/"/>
     */

    class Solution {
        public String lexPalindromicPermutation(String s, String target) {
            int[] left = new int[26];
            for (char b : s.toCharArray()) {
                left[b - 'a']++;
            }
            String midCh = "";
            for (int i = 0; i < 26; i++) {
                int c = left[i];
                if (c % 2 == 0) {
                    continue;
                }
                if (!midCh.isEmpty()) {
                    return "";
                }
                midCh = "" + (char) ('a' + i);
                left[i]--;
            }
            int n = s.length();
            for (int i = 0; i < n / 2; i++) {
                left[target.charAt(i) - 'a'] -= 2;
            }
            int neg = 0;
            int leftMax = 0;
            for (int i = 0; i < 26; i++) {
                if (left[i] < 0) {
                    neg++;
                } else if (left[i] > 0) {
                    leftMax = Math.max(leftMax, i);
                }
            }
            if (neg == 0) {
                String leftS = target.substring(0, n / 2);
                String rightS = midCh + new StringBuilder(leftS).reverse();
                if (rightS.compareTo(target.substring(n / 2)) > 0) {
                    return leftS + rightS;
                }
            }
            for (int i = n / 2 - 1; i >= 0; i--) {
                int b = target.charAt(i) - 'a';
                left[b] += 2;
                if (left[b] == 0) {
                    neg--;
                } else if (left[b] == 2) {
                    leftMax = Math.max(leftMax, b);
                }
                if (neg > 0 || leftMax <= b) {
                    continue;
                }
                int j = b + 1;
                while (left[j] == 0) {
                    j++;
                }
                left[j] -= 2;
                StringBuilder ans = new StringBuilder(target.substring(0, i + 1));
                ans.setCharAt(i, (char) ('a' + j));
                for (int k = 0; k < 26; k++) {
                    ans.repeat('a' + k, left[k] / 2);
                }
                StringBuilder rightS = new StringBuilder(ans).reverse();
                return ans.append(midCh).append(rightS).toString();
            }
            return "";
        }
    }

}
