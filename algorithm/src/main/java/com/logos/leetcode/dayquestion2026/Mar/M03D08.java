package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/8 10:23
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D08 {

    /**
     * 1980. 找出不同的二进制字符串
     * <a href="https://leetcode.cn/problems/find-unique-binary-string/description/"/>
     */

    class Solution {
        public String findDifferentBinaryString(String[] nums) {
            int n = nums.length;
            char[] ans = new char[n];
            for (int i = 0; i < n; i++) {
                ans[i] = (char) (nums[i].charAt(i) ^ 1);
            }
            return new String(ans);
        }
    }

}
