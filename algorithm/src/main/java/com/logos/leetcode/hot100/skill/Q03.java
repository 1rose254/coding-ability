package com.logos.leetcode.hot100.skill;

/**
 * @author logos
 * date 2026/3/16 20:45
 * @version v1.0
 * @Package com.logos.leetcode.hot100.skill
 */
public class Q03 {

    /**
     * 75. 颜色分类
     */

    class Solution {
        public void sortColors(int[] nums) {
            int cnt0 = 0;
            int cnt1 = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int x = nums[i];
                nums[i] = 2;
                if (x <= 1) {
                    nums[cnt1++] = 1;
                }
                if (x == 0) {
                    nums[cnt0++] = 0;
                }
            }
        }
    }

}
