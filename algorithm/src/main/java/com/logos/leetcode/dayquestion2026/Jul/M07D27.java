package com.logos.leetcode.dayquestion2026.Jul;

/**
 * @author logos
 * date 2026/7/26 23:38
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D27 {
    
    /**
     * 1464. 数组中两元素的最大乘积
     * <a href="https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/description/"/>
     */

    class Solution {
        public int maxProduct(int[] nums) {
            int max1 = 0;
            int max2 = 0;
            for (int x : nums) {
                if (x > max1) {
                    max2 = max1;
                    max1 = x;
                } else if (x > max2) {
                    max2 = x;
                }
            }
            return (max1 - 1) * (max2 - 1);
        }
    }

}
