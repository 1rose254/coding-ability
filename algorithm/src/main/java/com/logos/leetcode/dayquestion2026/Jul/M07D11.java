package com.logos.leetcode.dayquestion2026.Jul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/7/11 11:48
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D11 {

    /**
     * 2685. 统计完全连通分量的数量
     * <a href="https://leetcode.cn/problems/count-the-number-of-complete-components/description/"/>
     */

    class Solution {
        private int v;
        private int e;

        public int countCompleteComponents(int n, int[][] edges) {
            List<Integer>[] g = new ArrayList[n];
            Arrays.setAll(g, i -> new ArrayList<>());
            for (int[] e : edges) {
                int x = e[0];
                int y = e[1];
                g[x].add(y);
                g[y].add(x);
            }

            boolean[] vis = new boolean[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    v = 0;
                    e = 0;
                    dfs(i, g, vis);
                    if (e == v * (v - 1)) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private void dfs(int x, List<Integer>[] g, boolean[] vis) {
            v++;
            e += g[x].size();
            vis[x] = true;
            for (int y : g[x]) {
                if (!vis[y]) {
                    dfs(y, g, vis);
                }
            }
        }
    }

}
