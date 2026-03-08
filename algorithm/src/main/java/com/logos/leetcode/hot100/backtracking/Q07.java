package com.logos.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/8 15:20
 * @version v1.0
 * @Package com.logos.leetcode.hot100.backtracking
 */
public class Q07 {

    /**
     * 131. 分割回文串
     */

    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            dfs(s, 0, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void dfs(String s, int i, int start, List<String> path, List<List<String>> ans) {
            if (i == s.length()) {
                ans.add(new ArrayList<>(path));
                return;
            }
            if (i < s.length() - 1) {
                dfs(s, i + 1, start, path, ans);
            }
            if (isFlag(s, start, i)) {
                path.add(s.substring(start, i + 1));
                dfs(s, i + 1, i + 1, path, ans);
                path.remove(path.size() - 1);
            }
        }

        private boolean isFlag(String s, int l, int r) {
            while (l <= r) {
                if (s.charAt(l++) != s.charAt(r--)) {
                    return false;
                }
            }
            return true;
        }
    }

}
