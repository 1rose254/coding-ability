package com.logos.leetcode.dayquestion2026.Feb;

import com.logos.base.TreeNode;

import java.util.ArrayList;

/**
 * @author logos
 * date 2026/2/9 7:43
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D09 {


    /**
     * 1382. 将二叉搜索树变平衡
     * <a href="https://leetcode.cn/problems/balance-a-binary-search-tree/description/"/>
     */

    class Solution {
        ArrayList<Integer> list = new ArrayList<>();

        public void inorder(TreeNode root) {
            if (root == null){
                return;
            }
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }

        public TreeNode createBST(ArrayList<Integer> list, int l, int r) {
            if (r < l){
                return null;
            }
            int mid = l + (r - l) / 2;
            TreeNode root = new TreeNode(list.get(mid));
            root.left = createBST(list, l, mid-1);
            root.right = createBST(list, mid+1, r);
            return root;
        }

        public TreeNode balanceBST(TreeNode root) {
            inorder(root);
            return createBST(list, 0, list.size() - 1);
        }
    }

}
