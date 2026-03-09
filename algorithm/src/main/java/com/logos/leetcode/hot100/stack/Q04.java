package com.logos.leetcode.hot100.stack;

/**
 * @author logos
 * date 2026/3/9 16:35
 * @version v1.0
 * @Package com.logos.leetcode.hot100.stack
 */
public class Q04 {

    /**
     * 739. 每日温度
     */

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] ans = new int[n];
            int[] st = new int[n];
            int r = 0;
            for (int i = 0, cur = 0; i < n; i++) {
                while (r > 0 && temperatures[st[r - 1]] < temperatures[i]) {
                    cur = st[--r];
                    ans[cur] = i - cur;
                }
                st[r++] = i;
            }
            return ans;
        }
    }

}
