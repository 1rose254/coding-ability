package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/26 0:27
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D26 {

    /**
     * 1404. 将二进制表示减到 1 的步骤数
     * <a href="https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/"/>
     */

    class Solution {
        public int numSteps(String s) {
            int n = s.length();
            int ans = n - 1;
            int carry = 0;
            for (int i = n - 1; i > 0; i--) {
                int sum = s.charAt(i) - '0' + carry;
                ans += sum % 2;
                carry = (sum + sum % 2) / 2;
            }
            return ans + carry;
        }
    }

}
