package com.logos.leetcode.dayquestion2026.Jul;

/**
 * @author logos
 * date 2026/7/9 19:37
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D09 {

    /**
     * 3532. 针对图的路径存在性查询 I
     * <a href="https://leetcode.cn/problems/path-existence-queries-in-a-graph-i/description/"/>
     */

    class Solution {
        public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
            int[] id = new int[n];
            for (int i = 1; i < n; i++) {
                id[i] = id[i - 1];
                if (nums[i] - nums[i - 1] > maxDiff) {
                    id[i]++;
                }
            }

            boolean[] ans = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] q = queries[i];
                ans[i] = id[q[0]] == id[q[1]];
            }
            return ans;
        }
    }

}
