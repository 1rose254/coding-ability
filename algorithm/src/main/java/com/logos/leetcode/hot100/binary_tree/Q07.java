package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/3/6 15:00
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q07 {

    /**
     * 108. 将有序数组转换为二叉搜索树
     */

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            int n = nums.length;
            return build(nums, 0, n - 1);
        }

        private TreeNode build(int[] nums, int l, int r) {
            if (l > r) {
                return null;
            }
            int mid = l + (r - l) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = build(nums, l, mid - 1);
            root.right = build(nums, mid + 1, r);
            return root;
        }
    }

}
