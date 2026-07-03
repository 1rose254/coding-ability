package com.logos.leetcode.dayquestion2026.Jul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/7/3 19:45
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D03 {

    /**
     * 3620. 恢复网络路径
     * <a href="https://leetcode.cn/problems/network-recovery-pathways/description/"/>
     */

    class Solution {
        public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
            int n = online.length;
            List<int[]>[] g = new ArrayList[n];
            Arrays.setAll(g, i -> new ArrayList<>());
            int maxWt = -1;
            for (int[] e : edges) {
                int x = e[0], y = e[1], wt = e[2];
                if (online[x] && online[y]) {
                    g[x].add(new int[]{y, wt});
                    if (x == 0) {
                        maxWt = Math.max(maxWt, wt);
                    }
                }
            }

            long[] memo = new long[n];
            int left = -1, right = maxWt + 1;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                Arrays.fill(memo, -1L);
                if (dfs(0, mid, g, memo) <= k) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        private long dfs(int x, int lower, List<int[]>[] g, long[] memo) {
            if (x == g.length - 1) {
                return 0;
            }
            if (memo[x] != -1) {
                return memo[x];
            }
            long res = Long.MAX_VALUE / 2;
            for (int[] e : g[x]) {
                int y = e[0], wt = e[1];
                if (wt >= lower) {
                    res = Math.min(res, dfs(y, lower, g, memo) + wt);
                }
            }
            return memo[x] = res;
        }
    }

}
