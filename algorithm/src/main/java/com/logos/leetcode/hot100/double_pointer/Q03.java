package com.logos.leetcode.hot100.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/3/4 21:56
 * @version v1.0
 * @Package com.logos.leetcode.hot100.double_pointer
 */
public class Q03 {

    /**
     * 15. 三数之和
     */

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            Arrays.sort(nums);
            for (int i = 0; i < n - 2; i++) {
                if (nums[i] + nums[n - 2] + nums[n - 1] < 0) {
                    continue;
                }
                if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                    break;
                }
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        ans.add(List.of(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[++j])
                            ;
                        while (j < k && nums[k] == nums[--k])
                            ;
                    } else if (sum > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
            return ans;
        }
    }

}
