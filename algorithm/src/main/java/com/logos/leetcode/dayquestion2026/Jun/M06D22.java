package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/22 22:07
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D22 {

    /**
     * 1189. “气球” 的最大数量
     * <a href="https://leetcode.cn/problems/maximum-number-of-balloons/description/"/>
     */

    class Solution {
        public int maxNumberOfBalloons(String text) {
            int[] cnt = new int['z' + 1];
            for (char ch : text.toCharArray()) {
                cnt[ch]++;
            }
            return min(cnt['a'], cnt['b'], cnt['l'] / 2, cnt['n'], cnt['o'] / 2);
        }

        private int min(int... nums) {
            int res = nums[0];
            for (int x : nums) {
                res = Math.min(res, x);
            }
            return res;
        }
    }

}
