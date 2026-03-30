package com.logos.leetcode.dayquestion2026.Mar;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/3/30 9:57
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D30 {

    /**
     * 2840. 判断通过操作能否让字符串相等 II
     * <a href="https://leetcode.cn/problems/check-if-strings-can-be-made-equal-with-operations-ii/description/"/>
     */

    class Solution {
        public boolean checkStrings(String s1, String s2) {
            int[][] cnt1 = new int[2][26];
            int[][] cnt2 = new int[2][26];
            for (int i = 0; i < s1.length(); i++) {
                cnt1[i % 2][s1.charAt(i) - 'a']++;
                cnt2[i % 2][s2.charAt(i) - 'a']++;
            }
            return Arrays.deepEquals(cnt1, cnt2);
        }
    }

}
