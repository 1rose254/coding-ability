package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/14 09:54
 * @version v1.0
 */
public class M10D14 {


    /**
     * 3723. 数位平方和的最大值
     * <a href="https://leetcode.cn/problems/maximize-sum-of-squares-of-digits/description/"/>
     */
    class Solution {
        public String maxSumOfSquares(int n, int sum) {
            if (n * 9 < sum) {
                return "";
            }
            StringBuilder ans = new StringBuilder(n).repeat('9', sum / 9);
            if (sum % 9 > 0) {
                ans.append((char) ('0' + sum % 9));
            }
            ans.repeat('0', n - ans.length());
            return ans.toString();
        }
    }

}
