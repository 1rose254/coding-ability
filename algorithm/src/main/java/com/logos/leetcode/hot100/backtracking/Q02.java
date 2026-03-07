package com.logos.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/7 20:40
 * @version v1.0
 * @Package com.logos.leetcode.hot100.backtracking
 */
public class Q02 {

    /**
     * 78. 子集
     */

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            f(nums, 0, new int[n], 0, ans);
            return ans;
        }

        private void f(int[] nums, int i, int[] path, int size, List<List<Integer>> ans) {
            if (i == nums.length) {
                List<Integer> val = new ArrayList<>();
                for (int k = 0; k < size; k++) {
                    val.add(path[k]);
                }
                ans.add(val);
            } else {
                f(nums, i + 1, path, size, ans);
                path[size++] = nums[i];
                f(nums, i + 1, path, size, ans);
            }
        }
    }

}
