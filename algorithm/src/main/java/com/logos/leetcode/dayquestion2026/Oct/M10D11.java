package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/11 13:54
 * @version v1.0
 */
public class M10D11 {

    /**
     * 2778. 特殊元素平方和
     * <a href="https://leetcode.cn/problems/sum-of-squares-of-special-elements/description/"/>
     */

    class Solution {
        public int sumOfSquares(int[] nums) {
            int n = nums.length;
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    ans += nums[i - 1] * nums[i - 1];
                }
            }
            return ans;
        }
    }

}
