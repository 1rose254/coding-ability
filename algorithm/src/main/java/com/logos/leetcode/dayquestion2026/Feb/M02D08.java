package com.logos.leetcode.dayquestion2026.Feb;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/2/8 0:27
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D08 {

    /**
     * 110. 平衡二叉树
     * <a href="https://leetcode.cn/problems/balanced-binary-tree/description/"/>
     */

    class Solution {
        public static boolean balance;

        public boolean isBalanced(TreeNode root) {
            balance = true;
            hight(root);
            return balance;
        }

        public int hight(TreeNode root) {
            if (!balance || root == null) {
                return 0;
            }
            int l = hight(root.left);
            int r = hight(root.right);
            if (Math.abs(r - l) > 1) {
                balance = false;
                return 0;
            }
            return Math.max(l, r) + 1;
        }
    }

}
