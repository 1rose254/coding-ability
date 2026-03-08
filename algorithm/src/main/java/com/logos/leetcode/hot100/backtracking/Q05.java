package com.logos.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/8 14:58
 * @version v1.0
 * @Package com.logos.leetcode.hot100.backtracking
 */
public class Q05 {

    /**
     * 22. 括号生成
     */

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            char[] path = new char[2 * n];
            dfs(n, 0, 0, path, ans);
            return ans;
        }

        private void dfs(int n, int i, int open, char[] path, List<String> ans) {
            if (i == 2 * n) {
                ans.add(new String(path));
                return;
            }
            if (open < n) {
                path[i] = '(';
                dfs(n, i + 1, open + 1, path, ans);
            }
            if (i < open * 2) {
                path[i] = ')';
                dfs(n, i + 1, open, path, ans);
            }
        }
    }

}
