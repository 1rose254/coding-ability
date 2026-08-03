package com.logos.leetcode.dayquestion2026.Aug;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/8/2 12:11
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D03 {

    /**
     * 1406. 石子游戏 III
     * <a href="https://leetcode.cn/problems/stone-game-iii/description/"/>
     */

    class Solution {
        public String stoneGameIII(int[] stoneValue) {
            int n = stoneValue.length;
            int[] memo = new int[n];
            Arrays.fill(memo, Integer.MIN_VALUE);

            int diff = dfs(0, stoneValue, memo);
            if (diff == 0) {
                return "Tie";
            }
            return diff > 0 ? "Alice" : "Bob";
        }

        private int dfs(int i, int[] stoneValue, int[] memo) {
            if (i == stoneValue.length) {
                return 0;
            }

            if (memo[i] != Integer.MIN_VALUE) {
                return memo[i];
            }

            int res = Integer.MIN_VALUE;
            int sum = 0;
            for (int j = i; j < Math.min(i + 3, stoneValue.length); j++) {
                sum += stoneValue[j];
                res = Math.max(res, sum - dfs(j + 1, stoneValue, memo));
            }
            return memo[i] = res;
        }
    }

}
