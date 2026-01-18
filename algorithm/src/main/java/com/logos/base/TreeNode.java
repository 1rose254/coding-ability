package com.logos.base;

/**
 * @author logos
 * date 2026/1/18 21:32
 * @version v1.0
 * @Package com.logos.base
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
