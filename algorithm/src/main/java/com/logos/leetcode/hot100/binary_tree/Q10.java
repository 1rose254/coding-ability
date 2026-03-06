package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/6 18:34
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q10 {

    /**
     * 199. 二叉树的右视图
     */

    class Solution {
        private static List<Integer> ans = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {
            ans.clear();
            dfs(root, 0);
            return ans;
        }

        private void dfs(TreeNode root, int i) {
            if (root == null) {
                return;
            }
            if (i == ans.size()) {
                ans.add(root.val);
            }
            dfs(root.right, i + 1);
            dfs(root.left, i + 1);
        }
    }

}
