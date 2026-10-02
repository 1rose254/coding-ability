package com.logos.leetcode.dayquestion2026.Oct;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/2 09:48
 * @version v1.0
 */
public class M10D02 {

    /**
     * 22. 括号生成
     * <a href="https://leetcode.cn/problems/generate-parentheses/description/"/>
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
            if (i < 2 * open) {
                path[i] = ')';
                dfs(n, i + 1, open, path, ans);
            }
        }
    }

}
