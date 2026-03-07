package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/3/7 10:26
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q14 {

    /**
     * 236. 二叉树的最近公共祖先
     */

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode l = lowestCommonAncestor(root.left, p, q);
            TreeNode r = lowestCommonAncestor(root.right, p, q);
            if (l != null && r != null) {
                return root;
            }
            return l == null ? r : l;
        }
    }

}
