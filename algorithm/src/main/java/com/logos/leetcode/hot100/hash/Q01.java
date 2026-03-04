package com.logos.leetcode.hot100.hash;

import java.util.HashMap;

/**
 * @author logos
 * date 2026/3/4 10:55
 * @version v1.0
 * @Package com.logos.leetcode.hot100.hash
 */
public class Q01 {

    /**
     * 1. 两数之和
     */

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[] { i, map.get(target - nums[i]) };
                }
                map.put(nums[i], i);
            }
            return new int[] { -1, -1 };
        }
    }

}
