package com.logos.leetcode.hot100.binary_tree;

import com.logos.base.TreeNode;

import java.util.HashMap;

/**
 * @author logos
 * date 2026/3/7 10:22
 * @version v1.0
 * @Package com.logos.leetcode.hot100.binary_tree
 */
public class Q13 {

    /**
     * 437. 路径总和 III
     */

    class Solution {
        private static int ans;

        private static HashMap<Long, Integer> map = new HashMap<>();

        public int pathSum(TreeNode root, int targetSum) {
            ans = 0;
            map.clear();
            map.put(0L, 1);
            dfs(root, targetSum, 0L);
            return ans;
        }

        private void dfs(TreeNode root, int targetSum, long sum) {
            if (root == null) {
                return;
            }
            sum += root.val;
            ans += map.getOrDefault(sum - targetSum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            dfs(root.left, targetSum, sum);
            dfs(root.right, targetSum, sum);
            map.put(sum, map.get(sum) - 1);
        }
    }

}
