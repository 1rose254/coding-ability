package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/3/6 18:30
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q09 {

    /**
     * 230. 二叉搜索树中第K小的元素
     */

    class Solution {
        private static int ans, cnt;

        public int kthSmallest(TreeNode root, int k) {
            ans = 0;
            cnt = k;
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (--cnt == 0) {
                ans = root.val;
                return;
            }
            dfs(root.right);
        }
    }

}
