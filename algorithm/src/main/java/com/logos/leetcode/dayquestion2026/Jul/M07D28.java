package com.logos.leetcode.dayquestion2026.Jul;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/7/27 23:23
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D28 {

    /**
     * 3517. 最小回文排列 I
     * <a href="https://leetcode.cn/problems/smallest-palindromic-rearrangement-i/description/"/>
     */

    class Solution {
        public String smallestPalindrome(String s) {
            int n = s.length();
            int m = n / 2;
            char[] t = s.substring(0, m).toCharArray();
            Arrays.sort(t);
            StringBuilder ans = new StringBuilder(n);
            ans.append(t);
            if (n % 2 > 0) {
                ans.append(s.charAt(m));
            }
            for (int i = m - 1; i >= 0; i--) {
                ans.append(t[i]);
            }
            return ans.toString();
        }
    }

}
