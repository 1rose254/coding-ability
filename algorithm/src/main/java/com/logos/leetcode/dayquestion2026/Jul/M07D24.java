package com.logos.leetcode.dayquestion2026.Jul;

/**
 * @author logos
 * date 2026/7/23 21:13
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D24 {
    /**
     * 3514. 不同 XOR 三元组的数目 II
     * <a href="https://leetcode.cn/problems/number-of-unique-xor-triplets-ii/description/"/>
     */

    class Solution {
        public int uniqueXorTriplets(int[] nums) {
            int mx = 0;
            for (int x : nums) {
                mx = Math.max(mx, x);
            }
            int u = 1 << (32 - Integer.numberOfLeadingZeros(mx));
            boolean[] has = new boolean[u];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    has[nums[i] ^ nums[j]] = true;
                }
            }
            boolean[] has3 = new boolean[u];
            for (int xy = 0; xy < u; xy++) {
                if (!has[xy]) {
                    continue;
                }
                for (int z : nums) {
                    has3[xy ^ z] = true;
                }
            }
            int ans = 0;
            for (boolean b : has3) {
                if (b) {
                    ans++;
                }
            }
            return ans;
        }
    }

}
