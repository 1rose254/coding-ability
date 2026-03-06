package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/3/6 14:44
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q04 {

    /**
     * 101. 对称二叉树
     */

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return false;
            }
            return dfs(root.left, root.right);
        }

        private boolean dfs(TreeNode l, TreeNode r) {
            if (l == null && r == null) {
                return true;
            }
            if (l == null || r == null || l.val != r.val) {
                return false;
            }
            return dfs(l.left, r.right) && dfs(l.right, r.left);
        }
    }

}
