package com.logos.leetcode.dayquestion2026.Apr;

import java.util.*;

/**
 * @author logos
 * date 2026/4/21 9:16
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D21 {

    /**
     * 1722. 执行交换操作后的最小汉明距离
     * <a href="https://leetcode.cn/problems/minimize-hamming-distance-after-swap-operations/description/"/>
     */

    class Solution {
        public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
            int n = source.length;
            List<Integer>[] g = new ArrayList[n];
            Arrays.setAll(g, tmp -> new ArrayList<>());
            for (int[] e : allowedSwaps) {
                int i = e[0];
                int j = e[1];
                g[i].add(j);
                g[j].add(i);
            }

            boolean[] vis = new boolean[n];
            int ans = 0;
            for (int x = 0; x < n; x++) {
                if (!vis[x]) {
                    Map<Integer, Integer> diff = new HashMap<>();
                    dfs(x, source, target, g, vis, diff);
                    for (int c : diff.values()) {
                        ans += Math.abs(c);
                    }
                }
            }
            return ans / 2;
        }

        private void dfs(int x, int[] source, int[] target, List<Integer>[] g, boolean[] vis, Map<Integer, Integer> diff) {
            vis[x] = true;
            diff.merge(source[x], 1, Integer::sum);
            diff.merge(target[x], -1, Integer::sum);
            for (int y : g[x]) {
                if (!vis[y]) {
                    dfs(y, source, target, g, vis, diff);
                }
            }
        }
    }

}
