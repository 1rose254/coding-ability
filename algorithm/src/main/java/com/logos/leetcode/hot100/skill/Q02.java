package com.logos.leetcode.hot100.skill;

/**
 * @author logos
 * date 2026/3/16 20:43
 * @version v1.0
 * @Package com.logos.leetcode.hot100.skill
 */
public class Q02 {

    /**
     * 169. 多数元素
     */

    class Solution {
        public int majorityElement(int[] nums) {
            int ans = 0;
            int cnt = 0;
            for (int x : nums) {
                if (cnt == 0) {
                    ans = x;
                }
                cnt += ans == x ? 1 : -1;
            }
            return ans;
        }
    }

}
