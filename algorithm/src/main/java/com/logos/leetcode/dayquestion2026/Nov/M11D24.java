package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/24 13:13
 * @version v1.0
 */
public class M11D24 {

    /**
     * 3411. 最长乘积等价子数组
     * <a href="https://leetcode.cn/problems/maximum-subarray-with-equal-products/description/"/>
     */

    class Solution {
        public int maxLength(int[] nums) {
            int ans = 2;
            int mul = 1;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                while (gcd(mul, nums[right]) > 1) {
                    mul /= nums[left];
                    left++;
                }
                mul *= nums[right];
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }

        private int gcd(int a, int b) {
            while (a != 0) {
                int tmp = a;
                a = b % a;
                b = tmp;
            }
            return b;
        }
    }

}
