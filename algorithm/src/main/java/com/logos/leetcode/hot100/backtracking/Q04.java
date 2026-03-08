package com.logos.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/3/8 14:58
 * @version v1.0
 * @Package com.logos.leetcode.hot100.backtracking
 */
public class Q04 {

    /**
     * 39. 组合总和
     */

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            dfs(0, candidates, target, new ArrayList<>(), ans);
            return ans;
        }

        private void dfs(int i, int[] candidates, int target, List<Integer> path, List<List<Integer>> ans) {
            if (target == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int j = i; j < candidates.length; j++) {
                if (candidates[j] > target) {
                    return;
                }
                path.add(candidates[j]);
                dfs(j, candidates, target - candidates[j], path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

}
