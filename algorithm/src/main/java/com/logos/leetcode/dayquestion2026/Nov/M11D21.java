package com.logos.leetcode.dayquestion2026.Nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/21 11:19
 * @version v1.0
 */
public class M11D21 {

    /**
     * 3331. 修改后子树的大小
     * <a href="https://leetcode.cn/problems/find-subtree-sizes-after-changes/description/"/>
     */

    class Solution {
        public int[] findSubtreeSizes(int[] parent, String s) {
            int n = parent.length;
            List<Integer>[] g = new ArrayList[n];
            Arrays.setAll(g, i -> new ArrayList<>());
            for (int i = 1; i < n; i++) {
                g[parent[i]].add(i);
            }

            int[] size = new int[n];
            int[] ancestor = new int[26];
            Arrays.fill(ancestor, -1);
            dfs(0, g, s.toCharArray(), ancestor, size);
            return size;
        }

        private void dfs(int x, List<Integer>[] g, char[] s, int[] ancestor, int[] size) {
            size[x] = 1;
            int sx = s[x] - 'a';
            int old = ancestor[sx];
            ancestor[sx] = x;
            for (int y : g[x]) {
                dfs(y, g, s, ancestor, size);
                int anc = ancestor[s[y] - 'a'];
                size[anc < 0 ? x : anc] += size[y];
            }
            ancestor[sx] = old;
        }
    }

}
