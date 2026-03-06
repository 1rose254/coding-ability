package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/3/6 14:39
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q02 {

    /**
     * 104. 二叉树的最大深度
     */

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int lmax = maxDepth(root.left);
            int rmax = maxDepth(root.right);
            return Math.max(lmax, rmax) + 1;
        }
    }

}
