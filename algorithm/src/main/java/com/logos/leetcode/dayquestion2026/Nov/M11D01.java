package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/1 09:31
 * @version v1.0
 */
public class M11D01 {

    /**
     * 453. 最小操作次数使数组元素相等
     * <a href="https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/description/"/>
     */

    class Solution {
        public int minMoves(int[] nums) {
            long sum = 0;
            int min = Integer.MAX_VALUE;
            for (int x : nums) {
                sum += x;
                min = Math.min(min, x);
            }
            return (int) (sum - (long) min * nums.length);
        }
    }

}
