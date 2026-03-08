package com.logos.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/8 14:51
 * @version v1.0
 * @Package com.logos.leetcode.hot100.backtracking
 */
public class Q03 {

    /**
     * 17. 电话号码的字母组合
     */

    class Solution {
        private static final String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
                "wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            int n = digits.length();
            char[] path = new char[n];
            dfs(0, path, digits.toCharArray(), ans);
            return ans;
        }

        private void dfs(int i, char[] path, char[] digits, List<String> ans) {
            if (i == digits.length) {
                String val = new String(path);
                ans.add(val);
                return;
            }
            for (char c : map[digits[i] - '0'].toCharArray()) {
                path[i] = c;
                dfs(i + 1, path, digits, ans);
            }
        }
    }

}
