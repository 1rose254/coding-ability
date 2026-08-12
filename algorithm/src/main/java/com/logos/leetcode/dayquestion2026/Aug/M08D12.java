package com.logos.leetcode.dayquestion2026.Aug;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logos
 * date 2026/8/12 19:20
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D12 {

    /**
     * 2958. 最多 K 个重复元素的最长子数组
     * <a href="https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/description/"/>
     */

    class Solution {
        public int maxSubarrayLength(int[] nums, int k) {
            int ans = 0;
            int left = 0;
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int right = 0; right < nums.length; right++) {
                cnt.merge(nums[right], 1, Integer::sum);
                while (cnt.get(nums[right]) > k) {
                    cnt.merge(nums[left], -1, Integer::sum);
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }

}
