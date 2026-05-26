package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/26 8:35
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D26 {

    /**
     * 3120. 统计特殊字母的数量 I
     * <a href="https://leetcode.cn/problems/count-the-number-of-special-characters-i/description/"/>
     */

    class Solution {
        public int numberOfSpecialChars(String word) {
            int[] mask = new int[2];
            for (char c : word.toCharArray()) {
                mask[c >> 5 & 1] |= 1 << (c & 31);
            }
            return Integer.bitCount(mask[0] & mask[1]);
        }
    }

}
