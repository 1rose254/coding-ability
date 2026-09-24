package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/24 09:33
 * @version v1.0
 */
public class M09D24 {

    /**
     * 3550. 数位和等于下标的最小下标
     * <a href="https://leetcode.cn/problems/smallest-index-with-digit-sum-equal-to-index/description/"/>
     */

    class Solution {
        public int smallestIndex(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (i == getSum(nums[i])) {
                    return i;
                }
            }
            return -1;
        }

        public int getSum(int x) {
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            return sum;
        }
    }

}
