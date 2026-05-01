package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/1 10:13
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D01 {

    /**
     * 396. 旋转函数
     * <a href="https://leetcode.cn/problems/rotate-function/description/"/>
     */

    class Solution {
        public int maxRotateFunction(int[] nums) {
            int n = nums.length;
            int f = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                f += i * nums[i];
                sum += nums[i];
            }
            int ans = f;
            for (int i = n - 1; i > 0; i--) {
                f += sum - n * nums[i];
                ans = Math.max(ans, f);
            }
            return ans;
        }
    }

}
