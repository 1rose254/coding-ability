package com.logos.leetcode.hot100.skill;

/**
 * @author logos
 * date 2026/3/16 20:40
 * @version v1.0
 * @Package com.logos.leetcode.hot100.skill
 */
public class Q01 {

    /**
     * 136. 只出现一次的数字
     */

    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int x : nums) {
                ans ^= x;
            }
            return ans;
        }
    }

}
