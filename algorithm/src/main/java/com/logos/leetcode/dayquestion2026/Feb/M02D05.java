package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/5 0:02
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D05 {

    /**
     * 3379. 转换数组
     * <a href="https://leetcode.cn/problems/transformed-array/description/"/>
     */


    class Solution {
        public int[] constructTransformedArray(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = nums[((i + nums[i]) % n + n) % n];
            }
            return result;
        }
    }

}
