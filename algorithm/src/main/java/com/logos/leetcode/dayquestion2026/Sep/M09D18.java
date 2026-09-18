package com.logos.leetcode.dayquestion2026.Sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/18 09:46
 * @version v1.0
 */
public class M09D18 {

    /**
     * 1520. 最多的不重叠子字符串
     * <a href="https://leetcode.cn/problems/maximum-number-of-non-overlapping-substrings/description/"/>
     */

    class Solution {
        public List<String> maxNumOfSubstrings(String s) {
            int n = s.length();
            List<Integer>[] pos = new ArrayList[26];
            Arrays.setAll(pos, i -> new ArrayList<>());
            for (int i = 0; i < n; i++) {
                pos[s.charAt(i) - 'a'].add(i);
            }

            List<Integer>[] g = new ArrayList[26];
            Arrays.setAll(g, i -> new ArrayList<>());
            for (int i = 0; i < 26; i++) {
                if (pos[i].isEmpty()) {
                    continue;
                }
                List<Integer> p = pos[i];
                int l = p.get(0);
                int r = p.get(p.size() - 1);
                for (int j = 0; j < 26; j++) {
                    if (j == i) {
                        continue;
                    }
                    List<Integer> q = pos[j];
                    int k = lowerBound(q, l);
                    if (k < q.size() && q.get(k) <= r) {
                        g[i].add(j);
                    }
                }
            }

            List<int[]> intervals = new ArrayList<>();
            boolean[] vis = new boolean[26];
            for (int i = 0; i < 26; i++) {
                if (pos[i].isEmpty()) {
                    continue;
                }
                Arrays.fill(vis, false);
                l = n;
                r = 0;
                dfs(i, pos, g, vis);
                intervals.add(new int[]{l, r});
            }
            List<String> ans = new ArrayList<>();
            intervals.sort((a, b) -> a[1] - b[1]);
            int preR = -1;
            for (int[] p : intervals) {
                int l = p[0];
                int r = p[1];
                if (l > preR) {
                    ans.add(s.substring(l, r + 1));
                    preR = r;
                }
            }
            return ans;
        }

        private int l, r;

        private void dfs(int x, List<Integer>[] pos, List<Integer>[] g, boolean[] vis) {
            vis[x] = true;
            List<Integer> p = pos[x];
            l = Math.min(l, p.get(0));
            r = Math.max(r, p.get(p.size() - 1));
            for (int y : g[x]) {
                if (!vis[y]) {
                    dfs(y, pos, g, vis);
                }
            }
        }

        private int lowerBound(List<Integer> a, int target) {
            int left = -1;
            int right = a.size();
            while (left + 1 < right) {
                int mid = (left + right) >>> 1;
                if (a.get(mid) >= target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }
    }

}
