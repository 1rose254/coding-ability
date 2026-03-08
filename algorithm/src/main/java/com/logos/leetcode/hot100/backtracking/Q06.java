package com.logos.leetcode.hot100.backtracking;

/**
 * @author logos
 * date 2026/3/8 15:11
 * @version v1.0
 * @Package com.logos.leetcode.hot100.backtracking
 */
public class Q06 {

    /**
     * 79. 单词搜索
     */

    class Solution {
        public boolean exist(char[][] board, String word) {
            int n = board.length;
            int m = board[0].length;
            char[] wordArr = word.toCharArray();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dfs(board, wordArr, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            int n = board.length;
            int m = board[0].length;
            if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word[k]) {
                return false;
            }
            if (k == word.length - 1) {
                return true;
            }
            board[i][j] = '0';
            boolean ans = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1)
                    || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
            board[i][j] = word[k];
            return ans;
        }
    }

}
