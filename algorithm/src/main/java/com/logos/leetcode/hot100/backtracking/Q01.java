package com.logos.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/7 20:33
 * @version v1.0
 * @Package com.logos.leetcode.hot100.backtracking
 */
public class Q01 {

    /**
     * 46. 全排列
     */

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            f(nums, 0, ans);
            return ans;
        }

        private void f(int[] nums, int i, List<List<Integer>> ans) {
            if (i == nums.length) {
                List<Integer> val = new ArrayList<>();
                for (int k = 0; k < nums.length; k++) {
                    val.add(nums[k]);
                }
                ans.add(val);
            } else {
                for (int j = i; j < nums.length; j++) {
                    swap(nums, i, j);
                    f(nums, i + 1, ans);
                    swap(nums, i, j);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
