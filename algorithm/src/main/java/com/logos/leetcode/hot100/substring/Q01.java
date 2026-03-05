package com.logos.leetcode.hot100.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logos
 * date 2026/3/5 14:11
 * @version v1.0
 * @Package com.logos.leetcode.hot100.substring
 */
public class Q01 {

    /**
     * 560. 和为K的子数组
     */

    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            int sum = 0;
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                ans += map.getOrDefault(sum - k, 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return ans;
        }
    }

}
