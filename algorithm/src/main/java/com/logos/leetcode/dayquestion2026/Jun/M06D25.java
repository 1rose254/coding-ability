package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/25 23:21
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D25 {

    /**
     * 3737. 统计主要元素子数组数目 I
     * <a href="https://leetcode.cn/problems/count-subarrays-with-majority-element-i/description/"/>
     */

    class Solution {
        public int countMajoritySubarrays(int[] nums, int target) {
            int n = nums.length;
            int[] cnt = new int[n * 2 + 1];
            cnt[n] = 1;
            long ans = 0;
            int s = n;
            int f = 0;
            for (int x : nums) {
                if (x == target) {
                    f += cnt[s];
                    s++;
                } else {
                    s--;
                    f -= cnt[s];
                }
                ans += f;
                cnt[s]++;
            }
            return (int) ans;
        }
    }

}
