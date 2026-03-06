package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/6 14:56
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q06 {

    /**
     * 102. 二叉树的层序遍历
     */

    class Solution {
        private static final int MAX_N = 2005;

        private static TreeNode[] que = new TreeNode[MAX_N];

        private static int l, r;

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            l = r = 0;
            que[r++] = root;
            while (l < r) {
                int k = r - l;
                List<Integer> cur = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    TreeNode tmp = que[l++];
                    if (tmp.left != null) {
                        que[r++] = tmp.left;
                    }
                    if (tmp.right != null) {
                        que[r++] = tmp.right;
                    }
                    cur.add(tmp.val);
                }
                ans.add(cur);
            }
            return ans;
        }
    }

}
