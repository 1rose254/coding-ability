package com.logos.leetcode.dayquestion2026.Jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author logos
 * date 2026/1/27 0:11
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jan
 */
public class M01D27 {

    /**
     * 3650. 边反转的最小路径总成本
     * <a href="https://leetcode.cn/problems/minimum-cost-path-with-edge-reversals/description/"/>
     */

    class Solution {
        public int minCost(int n, int[][] edges) {
            List<int[]>[] g = new ArrayList[n];
            Arrays.setAll(g, i -> new ArrayList<>());
            for (int[] e : edges) {
                int x = e[0];
                int y = e[1];
                int wt = e[2];
                g[x].add(new int[]{y, wt});
                g[y].add(new int[]{x, wt * 2});
            }
            int[] dis = new int[n];
            Arrays.fill(dis, Integer.MAX_VALUE);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            dis[0] = 0;
            pq.offer(new int[]{0, 0});

            while (!pq.isEmpty()) {
                int[] p = pq.poll();
                int disX = p[0];
                int x = p[1];
                if (disX > dis[x]) {
                    continue;
                }
                if (x == n - 1) {
                    return disX;
                }
                for (int[] e : g[x]) {
                    int y = e[0];
                    int wt = e[1];
                    int newDisY = disX + wt;
                    if (newDisY < dis[y]) {
                        dis[y] = newDisY;
                        pq.offer(new int[]{newDisY, y});
                    }
                }
            }

            return -1;
        }
    }
}
