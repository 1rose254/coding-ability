package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/20 10:01
 * @version v1.0
 */
public class M09D20 {

    /**
     * 3498. 字符串的反转度
     * <a href="https://leetcode.cn/problems/reverse-degree-of-a-string/description/"/>
     */

    class Solution {
        public int reverseDegree(String s) {
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                ans += ('{' - s.charAt(i)) * (i + 1);
            }
            return ans;
        }
    }

}
