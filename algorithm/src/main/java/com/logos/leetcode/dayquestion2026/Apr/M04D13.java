package com.logos.leetcode.dayquestion2026.Apr;

/**
 * @author logos
 * date 2026/4/13 9:50
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D13 {

    /**
     * 1848. 到目标元素的最小距离
     * <a href="https://leetcode.cn/problems/minimum-distance-to-the-target-element/description/"/>
     */

    class Solution {
        public int getMinDistance(int[] nums, int target, int start) {
            for (int k = 0; ; k++) {
                if (start >= k && nums[start - k] == target ||
                        start + k < nums.length && nums[start + k] == target) {
                    return k;
                }
            }
        }
    }

}
