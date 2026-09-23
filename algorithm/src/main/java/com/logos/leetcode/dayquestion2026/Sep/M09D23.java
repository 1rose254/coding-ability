package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/23 11:02
 * @version v1.0
 */
public class M09D23 {

    /**
     * 1658. 将 x 减到 0 的最小操作数
     * <a href="https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/"/>
     */

    class Solution {
        public int minOperations(int[] nums, int x) {
            int target = -x;
            for (int num : nums) {
                target += num;
            }
            if (target < 0) {
                return -1;
            }
            int n = nums.length;
            int ans = -1;
            int sum = 0;
            int left = 0;
            for (int right = 0; right < n; right++) {
                sum += nums[right];
                while (sum > target) {
                    sum -= nums[left];
                    left++;
                }
                if (sum == target) {
                    ans = Math.max(ans, right - left + 1);
                }
            }
            return ans < 0 ? -1 : n - ans;
        }
    }

}
