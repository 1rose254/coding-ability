package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/17 10:16
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D17 {

    /**
     * 1306. 跳跃游戏 III
     * <a href="https://leetcode.cn/problems/jump-game-iii/description/"/>
     */

    class Solution {
        public boolean canReach(int[] arr, int start) {
            int n = arr.length;
            boolean[] vis = new boolean[n];
            return dfs(start, arr, vis);
        }

        private boolean dfs(int i, int[] arr, boolean[] vis) {
            if (i < 0 || i >= arr.length || vis[i]) {
                return false;
            }
            if (arr[i] == 0) {
                return true;
            }
            vis[i] = true;
            return dfs(i + arr[i], arr, vis) || dfs(i - arr[i], arr, vis);
        }
    }

}
