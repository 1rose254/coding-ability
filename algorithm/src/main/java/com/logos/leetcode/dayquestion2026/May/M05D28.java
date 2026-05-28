package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/28 8:59
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D28 {

    /**
     * 3093. 最长公共后缀查询
     * <a href="https://leetcode.cn/problems/longest-common-suffix-queries/description/"/>
     */

    class Node {
        Node[] son = new Node[26];
        int minLen = Integer.MAX_VALUE; // 子树中的最短字符串的长度
        int bestIndex; // 子树中的最短字符串的下标
    }

    class Solution {
        public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
            Node root = new Node();
            for (int i = 0; i < wordsContainer.length; i++) {
                char[] s = wordsContainer[i].toCharArray();
                if (s.length < root.minLen) {
                    root.minLen = s.length;
                    root.bestIndex = i;
                }

                Node cur = root;
                for (int j = s.length - 1; j >= 0; j--) {
                    int b = s[j] - 'a';
                    if (cur.son[b] == null) {
                        cur.son[b] = new Node();
                    }
                    cur = cur.son[b];
                    if (s.length < cur.minLen) {
                        cur.minLen = s.length;
                        cur.bestIndex = i;
                    }
                }
            }

            int[] ans = new int[wordsQuery.length];
            for (int i = 0; i < wordsQuery.length; i++) {
                String s = wordsQuery[i];
                Node cur = root;
                for (int j = s.length() - 1; j >= 0 && cur.son[s.charAt(j) - 'a'] != null; j--) {
                    cur = cur.son[s.charAt(j) - 'a'];
                }
                ans[i] = cur.bestIndex;
            }
            return ans;
        }
    }

}
