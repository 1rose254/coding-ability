package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/1 0:06
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D01 {

    /**
     * 1689. 十-二进制数的最少数目
     * <a href="https://leetcode.cn/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/"/>
     */

    class Solution {
        public int minPartitions(String n) {
            int mx = 0;
            for (char ch : n.toCharArray()) {
                mx = Math.max(mx, ch);
            }
            return mx - '0';
        }
    }

}
