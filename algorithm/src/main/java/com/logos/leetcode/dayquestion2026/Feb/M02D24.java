package com.logos.leetcode.dayquestion2026.Feb;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/2/24 0:52
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D24 {
    /**
     * 1022. 从根到叶的二进制数之和
     * <a href="https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/description/"/>
     */

    class Solution {
        public int sumRootToLeaf(TreeNode root) {
            return dfs(root, 0);
        }

        int dfs(TreeNode root, int cur) {
            int ans = 0;
            int ncur = (cur << 1) + root.val;
            if (root.left != null) {
                ans += dfs(root.left, ncur);
            }
            if (root.right != null) {
                ans += dfs(root.right, ncur);
            }
            return root.left == null && root.right == null ? ncur : ans;
        }
    }

}
