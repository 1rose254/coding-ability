package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/3 11:14
 * @version v1.0
 */
public class M11D03 {

    /**
     * 3736. 最小操作次数使数组元素相等 III
     * <a href="https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-iii/description/"/>
     */

    class Solution {
        public int minMoves(int[] nums) {
            int max = 0;
            int sum = 0;
            for (int x : nums) {
                max = Math.max(max, x);
                sum += x;
            }
            return max * nums.length - sum;
        }
    }

}
