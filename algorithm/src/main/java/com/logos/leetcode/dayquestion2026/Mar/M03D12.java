package com.logos.leetcode.dayquestion2026.Mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/3/12 8:09
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D12 {

    /**
     * 3600. 升级后最大生成树稳定性
     * <a href="https://leetcode.cn/problems/maximize-spanning-tree-stability-with-upgrades/description/"/>
     */

    class UnionFind {

        private final int[] fa;

        public int cc;

        UnionFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            cc = n;
        }

        public int find(int x) {
            if (fa[x] != x) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        public boolean merge(int from, int to) {
            int x = find(from);
            int y = find(to);
            if (x == y) {
                return false;
            }
            fa[x] = y;
            cc--;
            return true;
        }
    }

    class Solution {
        public int maxStability(int n, int[][] edges, int k) {
            UnionFind uf = new UnionFind(n);
            UnionFind allUf = new UnionFind(n);
            int minS1 = Integer.MAX_VALUE;
            for (int[] e : edges) {
                int x = e[0], y = e[1], s = e[2], must = e[3];
                if (must > 0) {
                    if (!uf.merge(x, y)) {
                        return -1;
                    }
                    minS1 = Math.min(minS1, s);
                }
                allUf.merge(x, y);
            }

            if (allUf.cc > 1) {
                return -1;
            }

            if (uf.cc == 1) {
                return minS1;
            }

            Arrays.sort(edges, (a, b) -> b[2] - a[2]);
            List<Integer> a = new ArrayList<>();
            for (int[] e : edges) {
                int x = e[0], y = e[1], s = e[2], must = e[3];
                if (must == 0 && uf.merge(x, y)) {
                    a.add(s);
                }
            }

            int m = a.size();
            int ans = Math.min(minS1, a.get(m - 1) * 2);
            if (k < m) {
                ans = Math.min(ans, a.get(m - 1 - k));
            }
            return ans;
        }
    }

}
