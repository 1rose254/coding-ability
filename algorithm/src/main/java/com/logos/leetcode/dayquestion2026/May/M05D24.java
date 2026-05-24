package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/24 9:02
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D24 {

    /**
     * 1340. 跳跃游戏 V
     * <a href="https://leetcode.cn/problems/jump-game-v/description/"/>
     */

    class Solution {
        public int maxJumps(int[] arr, int d) {
            int n = arr.length;
            int[] memo = new int[n];

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, dfs(i, arr, d, memo));
            }
            return ans;
        }

        private int dfs(int i, int[] arr, int d, int[] memo) {
            if (memo[i] > 0) {
                return memo[i];
            }

            int res = 1;

            for (int j = i - 1; j >= Math.max(i - d, 0) && arr[j] < arr[i]; j--) {
                res = Math.max(res, dfs(j, arr, d, memo) + 1);
            }

            for (int j = i + 1; j <= Math.min(i + d, arr.length - 1) && arr[j] < arr[i]; j++) {
                res = Math.max(res, dfs(j, arr, d, memo) + 1);
            }

            memo[i] = res;
            return res;
        }
    }

}
