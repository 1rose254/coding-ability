package com.logos.leetcode.dayquestion2026.Jun;

import java.util.HashMap;

/**
 * @author logos
 * date 2026/6/27 9:12
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D27 {

    /**
     * 3020. 子集中元素的最大数量
     * <a href="https://leetcode.cn/problems/find-the-maximum-number-of-elements-in-subset/description/"/>
     */

    class Solution {
        public int maximumLength(int[] nums) {
            HashMap<Long, Integer> cnt = new HashMap<>();
            for (int x : nums) {
                cnt.merge((long) x, 1, Integer::sum);
            }
            Integer cnt1 = cnt.remove(1L);
            int ans = cnt1 != null ? (cnt1 - 1) | 1 : 0;
            for (long x : cnt.keySet()) {
                int res = 0;
                while (cnt.getOrDefault(x, 0) >= 2) {
                    res += 2;
                    x *= x;
                }
                ans = Math.max(ans, res + (cnt.containsKey(x) ? 1 : -1));
            }
            return ans;
        }
    }

}
