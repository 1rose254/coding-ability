package com.logos.leetcode.dayquestion2026.Jun;

import com.logos.base.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author logos
 * date 2026/6/7 9:04
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D07 {

    /**
     * 2196. 根据描述创建二叉树
     * <a href="https://leetcode.cn/problems/create-binary-tree-from-descriptions/description/"/>
     */
    class Solution {
        public TreeNode createBinaryTree(int[][] descriptions) {
            int n = descriptions.length;
            Map<Integer, TreeNode> nodes = new HashMap<>(n + 1, 1);
            Set<Integer> children = new HashSet<>(n, 1);

            for (int[] d : descriptions) {
                int x = d[0], y = d[1];
                nodes.computeIfAbsent(x, i -> new TreeNode(x));
                nodes.computeIfAbsent(y, i -> new TreeNode(y));
                if (d[2] == 1) {
                    nodes.get(x).left = nodes.get(y);
                } else {
                    nodes.get(x).right = nodes.get(y);
                }
                children.add(y);
            }

            for (Map.Entry<Integer, TreeNode> e : nodes.entrySet()) {
                if (!children.contains(e.getKey())) {
                    return e.getValue();
                }
            }

            return null;
        }
    }

}
