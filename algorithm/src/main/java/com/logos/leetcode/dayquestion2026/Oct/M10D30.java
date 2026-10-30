package com.logos.leetcode.dayquestion2026.Oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/30 09:36
 * @version v1.0
 */
public class M10D30 {

    /**
     * 3970. 最多 K 个连续相同字符的最短路径
     * <a href="https://leetcode.cn/problems/shortest-path-with-at-most-k-consecutive-identical-characters/description/"/>
     */

    final class Solution {
        public int shortestPath(int n, int[][] edges, String labels, int k) {
            char[] s = labels.toCharArray();
            List<int[]>[] g = new ArrayList[n];
            Arrays.setAll(g, i -> new ArrayList<>());
            for (int[] e : edges) {
                g[e[0]].add(new int[]{e[1], e[2]});
            }

            int[][] dis = new int[n][k + 1];
            for (int[] row : dis) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            pq.add(new int[]{0, 0, 1});

            while (!pq.isEmpty()) {
                int[] top = pq.poll();
                int d = top[0];
                int x = top[1];
                int cnt = top[2];
                if (x == n - 1) {
                    return d;
                }
                if (d > dis[x][cnt]) {
                    continue;
                }
                for (int[] e : g[x]) {
                    int y = e[0];
                    int newCnt = s[y] == s[x] ? cnt + 1 : 1;
                    int newDis = d + e[1];
                    if (newCnt <= k && newDis < dis[y][newCnt]) {
                        dis[y][newCnt] = newDis;
                        pq.add(new int[]{newDis, y, newCnt});
                    }
                }
            }

            return -1;
        }
    }

}
