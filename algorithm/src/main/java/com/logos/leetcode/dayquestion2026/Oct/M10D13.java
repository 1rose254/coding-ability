package com.logos.leetcode.dayquestion2026.Oct;

import java.util.Arrays;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/13 10:24
 * @version v1.0
 */
public class M10D13 {

    /**
     * 3727. 最大交替平方和
     * <a href="https://leetcode.cn/problems/maximum-alternating-sum-of-squares/description/"/>
     */

    class Solution {
        public long maxAlternatingSum(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                nums[i] *= nums[i];
            }
            Arrays.sort(nums);
            int m = n / 2;
            long ans = 0;
            for (int i = 0; i < m; i++) {
                ans -= nums[i];
            }
            for (int i = m; i < n; i++) {
                ans += nums[i];
            }
            return ans;
        }
    }

}
