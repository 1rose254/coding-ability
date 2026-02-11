package com.logos.leetcode.dayquestion2026.Feb;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logos
 * date 2026/2/11 11:35
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D11 {


    /**
     * 3721. 最长平衡子数组 II
     * <a href="https://leetcode.cn/problems/longest-balanced-subarray-ii/description/"/>
     */

    class LazySegmentTree {
        private static final class Node {
            int min;
            int max;
            int todo;
        }

        private void apply(int node, int todo) {
            Node cur = tree[node];
            cur.min += todo;
            cur.max += todo;
            cur.todo += todo;
        }

        private final int n;
        private final Node[] tree;

        public LazySegmentTree(int n) {
            this.n = n;
            tree = new Node[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
            Arrays.setAll(tree, i -> new Node());
        }

        public void update(int ql, int qr, int f) {
            update(1, 0, n - 1, ql, qr, f);
        }

        public int findFirst(int ql, int qr, int target) {
            return findFirst(1, 0, n - 1, ql, qr, target);
        }

        private void spread(int node) {
            int todo = tree[node].todo;
            if (todo == 0) {
                return;
            }
            apply(node * 2, todo);
            apply(node * 2 + 1, todo);
            tree[node].todo = 0;
        }

        private void maintain(int node) {
            tree[node].min = Math.min(tree[node * 2].min, tree[node * 2 + 1].min);
            tree[node].max = Math.max(tree[node * 2].max, tree[node * 2 + 1].max);
        }

        private void update(int node, int l, int r, int ql, int qr, int f) {
            if (ql <= l && r <= qr) {
                apply(node, f);
                return;
            }
            spread(node);
            int m = (l + r) / 2;
            if (ql <= m) {
                update(node * 2, l, m, ql, qr, f);
            }
            if (qr > m) {
                update(node * 2 + 1, m + 1, r, ql, qr, f);
            }
            maintain(node);
        }

        private int findFirst(int node, int l, int r, int ql, int qr, int target) {
            if (l > qr || r < ql || target < tree[node].min || target > tree[node].max) {
                return -1;
            }
            if (l == r) {
                return l;
            }
            spread(node);
            int m = (l + r) / 2;
            int idx = findFirst(node * 2, l, m, ql, qr, target);
            if (idx < 0) {
                idx = findFirst(node * 2 + 1, m + 1, r, ql, qr, target);
            }
            return idx;
        }
    }

    class Solution {
        public int longestBalanced(int[] nums) {
            int n = nums.length;
            LazySegmentTree t = new LazySegmentTree(n + 1);
            Map<Integer, Integer> last = new HashMap<>();
            int ans = 0;
            int curSum = 0;

            for (int i = 1; i <= n; i++) {
                int x = nums[i - 1];
                int v = x % 2 > 0 ? 1 : -1;
                Integer j = last.get(x);
                if (j == null) {
                    curSum += v;
                    t.update(i, n, v);
                } else {
                    t.update(j, i - 1, -v);
                }
                last.put(x, i);

                int l = t.findFirst(0, i - 1 - ans, curSum);
                if (l >= 0) {
                    ans = i - l;
                }
            }
            return ans;
        }
    }

}
