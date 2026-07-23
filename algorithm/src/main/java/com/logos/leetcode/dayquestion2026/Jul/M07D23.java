package com.logos.leetcode.dayquestion2026.Jul;

/**
 * @author logos
 * date 2026/7/23 21:11
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D23 {

    /**
     * 3513. 不同 XOR 三元组的数目 I
     * <a href="https://leetcode.cn/problems/number-of-unique-xor-triplets-i/description/"/>
     */

    class Solution {
        public int uniqueXorTriplets(int[] nums) {
            int n = nums.length;
            return n <= 2 ? n : 1 << (32 - Integer.numberOfLeadingZeros(n));
        }
    }

}
