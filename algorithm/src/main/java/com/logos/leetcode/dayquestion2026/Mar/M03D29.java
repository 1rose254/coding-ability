package com.logos.leetcode.dayquestion2026.Mar;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/3/29 22:18
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D29 {

    /**
     * 2839. 判断通过操作能否让字符串相等 I
     * <a href="https://leetcode.cn/problems/check-if-strings-can-be-made-equal-with-operations-i/description/"/>
     */

    class Solution {
        public boolean canBeEqual(String s1, String s2) {
            var cnt1 = new int[2][26];
            var cnt2 = new int[2][26];
            for (int i = 0; i < s1.length(); i++) {
                cnt1[i % 2][s1.charAt(i) - 'a']++;
                cnt2[i % 2][s2.charAt(i) - 'a']++;
            }
            return Arrays.deepEquals(cnt1, cnt2);
        }
    }

}
