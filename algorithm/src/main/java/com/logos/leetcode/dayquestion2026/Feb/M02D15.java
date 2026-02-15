package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/15 13:25
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D15 {

    /**
     * 67. 二进制求和
     * <a href="https://leetcode.cn/problems/add-binary/description/"/>
     */

    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;
            for (; i >= 0 || j >= 0; i--, j--) {
                if (i >= 0) {
                    carry += a.charAt(i) - '0';
                }
                if (j >= 0) {
                    carry += b.charAt(j) - '0';
                }
                sb.append(carry % 2);
                carry /= 2;
            }
            if (carry > 0)
                sb.append('1');
            return sb.reverse().toString();
        }
    }

}
