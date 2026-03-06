package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/3/6 14:51
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q05 {

    /**
     * 543. 二叉树的直径
     */

    class Solution {
        private static int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            ans = 0;
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = dfs(root.left);
            int r = dfs(root.right);
            ans = Math.max(ans, l + r);
            return Math.max(l, r) + 1;
        }
    }

}
