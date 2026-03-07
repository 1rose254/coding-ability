package com.logos.leetcode.hot100.graph_theory;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/3/7 20:27
 * @version v1.0
 * @Package com.logos.leetcode.hot100.graph_theory
 */
public class Q04 {

    /**
     * 208. 实现 Trie (前缀树)
     */

    class Trie {
        private static int MAX_N = 30700;

        private static int[][] tree = new int[MAX_N][26];

        private static int[] pass = new int[MAX_N];

        private static int[] end = new int[MAX_N];

        private static int cnt;

        private void clear() {
            for (int i = 1; i <= cnt; i++) {
                Arrays.fill(tree[i], 0);
                pass[i] = 0;
                end[i] = 0;
            }
        }

        private void build() {
            cnt = 1;
        }

        public Trie() {
            clear();
            build();
        }

        public void insert(String word) {
            int cur = 1;
            pass[cur]++;
            for (int i = 0, path = 0; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (tree[cur][path] == 0) {
                    tree[cur][path] = ++cnt;
                }
                cur = tree[cur][path];
                pass[cur]++;
            }
            end[cur]++;
        }

        public boolean search(String word) {
            int cur = 1;
            for (int i = 0, path = 0; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (tree[cur][path] == 0) {
                    return false;
                }
                cur = tree[cur][path];
            }
            return end[cur] > 0;
        }

        public boolean startsWith(String prefix) {
            int cur = 1;
            for (int i = 0, path = 0; i < prefix.length(); i++) {
                path = prefix.charAt(i) - 'a';
                if (tree[cur][path] == 0) {
                    return false;
                }
                cur = tree[cur][path];
            }
            return pass[cur] > 0;
        }
    }

}
