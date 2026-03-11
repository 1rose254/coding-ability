package com.logos.leetcode.hot100.greedy_algorithm;

/**
 * @author logos
 * date 2026/3/11 16:29
 * @version v1.0
 * @Package com.logos.leetcode.hot100.greedy_algorithm
 */
public class Q03 {

    /**
     * 45. 跳跃游戏 II
     */

    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return 0;
            }
            int ans = 0;
            int next = 0;
            int cover = 0;
            for (int i = 0; i < n - 1; i++) {
                next = Math.max(next, nums[i] + i);
                if (i == cover) {
                    cover = next;
                    ans++;
                }
            }
            return ans;
        }
    }

}
