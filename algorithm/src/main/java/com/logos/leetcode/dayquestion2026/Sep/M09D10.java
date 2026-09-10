package com.logos.leetcode.dayquestion2026.Sep;

import com.logos.base.TreeNode;

/**
 * @author logos
 * date 2026/9/10 09:47
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Sep
 */
public class M09D10 {

    /**
     * 2265. 统计值等于子树平均值的节点数
     * <a href="https://leetcode.cn/problems/count-nodes-equal-to-average-of-subtree/description/"/>
     */

    class Solution {
        private int ans = 0;

        public int averageOfSubtree(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int[] dfs(TreeNode node) {
            if (node == null) {
                return new int[]{0, 0};
            }
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            int sum = left[0] + right[0] + node.val;
            int size = left[1] + right[1] + 1;
            if (node.val == sum / size) {
                ans++;
            }
            return new int[]{sum, size};
        }
    }

}
