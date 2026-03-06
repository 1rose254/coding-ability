package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/6 14:38
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q01 {

    /**
     * 94. 二叉树中序遍历
     */

    class Solution {
        private static List<Integer> ans = new ArrayList<>();

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            ans.add(root.val);
            dfs(root.right);
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            ans.clear();
            dfs(root);
            return ans;
        }
    }

}
