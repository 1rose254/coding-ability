package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/14 9:41
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D14 {

    /**
     * 2784. 检查数组是否是好的
     * <a href="https://leetcode.cn/problems/check-if-array-is-good/description/"/>
     */

    class Solution {
        public boolean isGood(int[] nums) {
            int n = nums.length - 1;
            int[] cnt = new int[n + 1];
            for (int x : nums) {
                if (x > n ||
                        x == n && cnt[x] > 1 ||
                        x < n && cnt[x] > 0) {
                    return false;
                }
                cnt[x]++;
            }
            return true;
        }
    }

}
