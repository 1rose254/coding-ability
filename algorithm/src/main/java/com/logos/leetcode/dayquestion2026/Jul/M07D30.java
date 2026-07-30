package com.logos.leetcode.dayquestion2026.Jul;

/**
 * @author logos
 * date 2026/7/29 23:04
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D30 {

    /**
     * 3014. 输入单词需要的最少按键次数 I
     * <a href="https://leetcode.cn/problems/minimum-number-of-pushes-to-type-word-i/description/"/>
     */

    class Solution {
        public int minimumPushes(String word) {
            int n = word.length();
            int k = n / 8;
            return (k * 4 + n % 8) * (k + 1);
        }
    }

}
