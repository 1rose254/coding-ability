package com.logos.leetcode.dayquestion2026.Jan;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/1/25 0:00
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jan
 */
public class M01D24 {


    /**
     * 1877. 数组中最大数对和的最小值
     * <a href="https://leetcode.cn/problems/minimize-maximum-pair-sum-in-array/description/"/>
     */

    class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int ans = 0;
            for (int i = 0; i < n / 2; i++) {
                ans = Math.max(ans, nums[i] + nums[n - 1 - i]);
            }
            return ans;
        }
    }

}
