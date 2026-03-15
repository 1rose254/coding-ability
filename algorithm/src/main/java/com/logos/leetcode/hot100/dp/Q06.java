package com.logos.leetcode.hot100.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author logos
 * date 2026/3/15 16:45
 * @version v1.0
 * @Package com.logos.leetcode.hot100.dp
 */
public class Q06 {

    /**
     * 139. 单词拆分
     */

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int maxLen = 0;
            for (String word : wordDict) {
                maxLen = Math.max(maxLen, word.length());
            }
            Set<String> words = new HashSet<>(wordDict);
            int n = s.length();
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return dfs(n, maxLen, s, words, dp) == 1;
        }

        private int dfs(int i, int maxLen, String s, Set<String> words, int[] dp) {
            if (i == 0) {
                return 1;
            }
            if (dp[i] != -1) {
                return dp[i];
            }
            for (int j = i - 1; j >= Math.max(i - maxLen, 0); j--) {
                if (words.contains(s.substring(j, i)) && dfs(j, maxLen, s, words, dp) == 1) {
                    return dp[i] = 1;
                }
            }
            return dp[i] = 0;
        }
    }

}
