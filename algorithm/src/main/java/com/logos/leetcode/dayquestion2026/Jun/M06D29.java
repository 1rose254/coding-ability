package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/29 22:06
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D29 {

    /**
     * 1967. 作为子字符串出现在单词中的字符串数目
     * <a href="https://leetcode.cn/problems/number-of-strings-that-appear-as-substrings-in-word/description/"/>
     */

    class Solution {
        public int numOfStrings(String[] patterns, String word) {
            int ans = 0;
            for (String pattern : patterns) {
                if (word.contains(pattern)) {
                    ans++;
                }
            }
            return ans;
        }
    }

}
