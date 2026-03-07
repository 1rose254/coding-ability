package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/3/7 10:27
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q15 {

    /**
     * 124. 二叉树中的最大路径和
     */

    class Solution {

        private static int ans;

        public int maxPathSum(TreeNode root) {
            ans = Integer.MIN_VALUE;
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = dfs(root.left);
            int r = dfs(root.right);
            ans = Math.max(ans, l + r + root.val);
            return Math.max(0, Math.max(l, r) + root.val);
        }
    }

}
