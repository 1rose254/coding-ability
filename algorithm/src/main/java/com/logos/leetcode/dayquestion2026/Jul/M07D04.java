package com.logos.leetcode.dayquestion2026.Jul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/7/4 17:15
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D04 {

    /**
     * 2492. 两个城市间路径的最小分数
     * <a href="https://leetcode.cn/problems/minimum-score-of-a-path-between-two-cities/description/"/>
     */

    class Solution {
        private int ans = Integer.MAX_VALUE;

        public int minScore(int n, int[][] roads) {
            List<int[]>[] g = new ArrayList[n + 1];
            Arrays.setAll(g, i -> new ArrayList<>());
            for (int[] e : roads) {
                int x = e[0], y = e[1], dis = e[2];
                g[x].add(new int[]{y, dis});
                g[y].add(new int[]{x, dis});
            }

            boolean[] vis = new boolean[n + 1];
            dfs(1, g, vis);
            return ans;
        }

        private void dfs(int x, List<int[]>[] g, boolean[] vis) {
            vis[x] = true;
            for (int[] e : g[x]) {
                ans = Math.min(ans, e[1]);
                if (!vis[e[0]]) {
                    dfs(e[0], g, vis);
                }
            }
        }
    }

}
