package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/13 9:21
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D13 {

    /**
     * 1674. 使数组互补的最少操作次数
     * <a href="https://leetcode.cn/problems/minimum-moves-to-make-array-complementary/description/"/>
     */

    class Solution {
        public int minMoves(int[] nums, int limit) {
            int n = nums.length;
            int[] diff = new int[limit * 2 + 2];

            for (int i = 0; i < n / 2; i++) {
                int x = nums[i];
                int y = nums[n - 1 - i];
                int l = Math.min(x, y) + 1;
                int r = Math.max(x, y) + limit;
                diff[l]--;
                diff[x + y]--;
                diff[x + y + 1]++;
                diff[r + 1]++;
            }

            int ans = Integer.MAX_VALUE;
            int sum = n;
            for (int i = 2; i <= limit * 2; i++) {
                sum += diff[i];
                ans = Math.min(ans, sum);
            }
            return ans;
        }
    }

}
