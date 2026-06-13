package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/13 8:50
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D13 {

    /**
     * 3838. 带权单词映射
     * <a href="https://leetcode.cn/problems/weighted-word-mapping/description/"/>
     */
    class Solution {
        public String mapWordWeights(String[] words, int[] weights) {
            int n = words.length;
            char[] ans = new char[n];
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (char ch : words[i].toCharArray()) {
                    sum += weights[ch - 'a'];
                }
                ans[i] = (char) ('z' - sum % 26);
            }
            return new String(ans);
        }
    }

}
