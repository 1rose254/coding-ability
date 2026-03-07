package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

import java.util.HashMap;

/**
 * @author logos
 * date 2026/3/6 18:44
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q12 {

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     */

    class Solution {
        private static HashMap<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            map.clear();
            int n = preorder.length;
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return build(preorder, 0, n - 1, inorder, 0, n - 1);
        }

        private TreeNode build(int[] pre, int l1, int r1, int[] in, int l2, int r2) {
            if (l1 > r1) {
                return null;
            }
            TreeNode root = new TreeNode(pre[l1]);
            if (l1 == r1) {
                return root;
            }
            int k = map.get(pre[l1]);
            root.left = build(pre, l1 + 1, l1 + k - l2, in, l2, k - 1);
            root.right = build(pre, l1 + k - l2 + 1, r1, in, k + 1, r2);
            return root;
        }
    }

}
