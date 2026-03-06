package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/3/6 18:27
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q08 {

    /**
     * 98. 验证二叉搜索树
     */

    class Solution {
        private long minVal, maxVal;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                minVal = Long.MAX_VALUE;
                maxVal = Long.MIN_VALUE;
                return true;
            }
            boolean l = isValidBST(root.left);
            long lmin = minVal;
            long lmax = maxVal;
            boolean r = isValidBST(root.right);
            long rmin = minVal;
            long rmax = maxVal;
            minVal = Math.min(root.val, Math.min(lmin, rmin));
            maxVal = Math.max(root.val, Math.max(lmax, rmax));
            return l && r && lmax < root.val && root.val < rmin;
        }
    }

}
