package com.logos.leetcode.dayquestion2026.Aug;

/**
 * @author logos
 * date 2026/8/30 10:27
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D30 {

    /**
     * 2091. 从数组中移除最大值和最小值
     * <a href="https://leetcode.cn/problems/removing-minimum-and-maximum-from-array/description/"/>
     */

    class Solution {
        public int minimumDeletions(int[] nums) {
            int n = nums.length;
            int p = 0;
            int q = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] < nums[p]) {
                    p = i;
                } else if (nums[i] > nums[q]) {
                    q = i;
                }
            }
            if (p > q) {
                int tmp = p;
                p = q;
                q = tmp;
            }
            return Math.min(Math.min(q + 1, n - p), p + 1 + n - q);
        }
    }

}
