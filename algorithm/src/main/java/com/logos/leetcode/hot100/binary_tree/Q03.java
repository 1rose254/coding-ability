package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/3/6 14:40
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q03 {

    /**
     * 226. 翻转二叉树
     */

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode l = invertTree(root.left);
            TreeNode r = invertTree(root.right);
            root.left = r;
            root.right = l;
            return root;
        }
    }

}
