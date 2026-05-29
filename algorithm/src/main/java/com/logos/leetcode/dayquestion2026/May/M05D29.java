package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/29 10:41
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D29 {

    /**
     * 3300. 替换为数位和以后的最小元素
     * <a href="https://leetcode.cn/problems/minimum-element-after-replacement-with-digit-sum/description/"/>
     */
    class Solution {
        public int minElement(int[] nums) {
            int ans = Integer.MAX_VALUE;
            for (int x : nums) {
                int s = 0;
                while (x > 0) {
                    s += x % 10;
                    x /= 10;
                }
                ans = Math.min(ans, s);
            }
            return ans;
        }
    }

}
