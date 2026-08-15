package com.logos.leetcode.dayquestion2026.Aug;

/**
 * @author logos
 * date 2026/8/15 11:50
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D15 {

    /**
     * 3702. 按位异或非零的最长子序列
     * <a href="https://leetcode.cn/problems/longest-subsequence-with-non-zero-bitwise-xor/description/"/>
     */

    class Solution {
        public int longestSubsequence(int[] nums) {
            boolean hasNonZero = false;
            int xor = 0;
            for (int x : nums) {
                hasNonZero = hasNonZero || x != 0;
                xor ^= x;
            }
            if (!hasNonZero) {
                return 0;
            }

            int ans = nums.length;
            if (xor == 0) {
                ans--;
            }
            return ans;
        }
    }

}
