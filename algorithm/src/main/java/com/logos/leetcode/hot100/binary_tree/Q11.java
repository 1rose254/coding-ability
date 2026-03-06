package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/3/6 18:38
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q11 {

    /**
     * 114. 二叉树展开为链表
     */

    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.left);
            flatten(root.right);
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null) {
                root = root.right;
            }
            root.right = tmp;
        }
    }

}
