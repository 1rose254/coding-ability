package com.logos.leetcode.dayquestion2026.Aug;

/**
 * @author logos
 * date 2026/7/31 22:44
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D01 {

    /**
     * 486. 预测赢家
     * <a href="https://leetcode.cn/problems/predict-the-winner/description/"/>
     */

    class Solution {
        public boolean predictTheWinner(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int n = nums.length;
            int[][] dp = new int[n][n];
            for (int l = 0; l < n - 1; l++) {
                dp[l][l] = nums[l];
                dp[l][l + 1] = Math.max(nums[l], nums[l + 1]);
            }
            dp[n - 1][n - 1] = nums[n - 1];
            for (int l = n - 3; l >= 0; l--) {
                for (int r = l + 2; r < n; r++) {
                    int p1 = nums[l] + Math.min(dp[l + 2][r], dp[l + 1][r - 1]);
                    int p2 = nums[r] + Math.min(dp[l + 1][r - 1], dp[l][r - 2]);
                    dp[l][r] = Math.max(p1, p2);
                }
            }
            int first = dp[0][n - 1];
            int second = sum - first;
            return first >= second;
        }
    }

}
