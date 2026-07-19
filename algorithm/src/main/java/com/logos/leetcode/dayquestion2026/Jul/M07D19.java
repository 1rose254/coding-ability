package com.logos.leetcode.dayquestion2026.Jul;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/7/19 12:04
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D19 {

    /**
     * 1081. 不同字符的最小子序列
     * <a href="https://leetcode.cn/problems/smallest-subsequence-of-distinct-characters/description/"/>
     */

    class Solution {
        public int MAX_N = 26;

        public char[] stack = new char[MAX_N];

        public int size;

        public int[] cnts = new int[MAX_N];

        public boolean[] enters = new boolean[MAX_N];

        public String smallestSubsequence(String s) {
            Arrays.fill(enters, false);
            Arrays.fill(cnts, 0);
            char[] charArr = s.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                cnts[charArr[i] - 'a']++;
            }
            for (int i = 0; i < charArr.length; i++) {
                if (!enters[charArr[i] - 'a']) {
                    while (size > 0 && charArr[i] <= stack[size - 1] && cnts[stack[size - 1] - 'a'] > 0) {
                        enters[stack[size - 1] - 'a'] = false;
                        size--;
                    }
                    stack[size++] = charArr[i];
                    enters[charArr[i] - 'a'] = true;
                }
                cnts[charArr[i] - 'a']--;
            }
            return String.valueOf(stack, 0, size);
        }
    }

}
