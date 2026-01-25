package com.logos.leetcode.dayquestion2026.Jan;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/1/25 20:10
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jan
 */
public class M01D25 {


    /**
     * 1984. 学生分数的最小差值
     * <a href="https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/"/>
     */

    class Solution {
        public int minimumDifference(int[] nums, int k) {
            Arrays.sort(nums);
            int ans = Integer.MAX_VALUE;
            for (int i = k - 1; i < nums.length; i++) {
                ans = Math.min(ans, nums[i] - nums[i - k + 1]);
            }
            return ans;
        }
    }

}
