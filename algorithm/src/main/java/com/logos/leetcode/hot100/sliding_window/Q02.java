package com.logos.leetcode.hot100.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/3/5 14:07
 * @version v1.0
 * @Package com.logos.leetcode.hot100.sliding_window
 */
public class Q02 {

    /**
     * 438. 找到字符串中所有字母异位词
     */

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            if (s.length() < p.length()) {
                return ans;
            }
            char[] sArr = s.toCharArray();
            char[] pArr = p.toCharArray();
            int[] cntp = new int[26];
            int[] cnts = new int[26];
            for (int i = 0; i < pArr.length; i++) {
                cntp[pArr[i] - 'a']++;
            }
            for (int left = 0, right = 0; right < sArr.length; right++) {
                cnts[sArr[right] - 'a']++;
                while (right - left + 1 > pArr.length) {
                    cnts[sArr[left++] - 'a']--;
                }
                if (Arrays.equals(cnts, cntp)) {
                    ans.add(left);
                }
            }
            return ans;
        }
    }

}
