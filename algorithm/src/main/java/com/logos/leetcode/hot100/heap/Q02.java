package com.logos.leetcode.hot100.heap;

import java.util.*;

/**
 * @author logos
 * date 2026/3/9 16:52
 * @version v1.0
 * @Package com.logos.leetcode.hot100.heap
 */
public class Q02 {

    /**
     * 347. 前 K 个高频元素
     */

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            int n = nums.length;
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int x : nums) {
                cnt.merge(x, 1, Integer::sum);
            }
            int maxCnt = Collections.max(cnt.values());
            List<Integer>[] buckets = new ArrayList[maxCnt + 1];
            Arrays.setAll(buckets, i -> new ArrayList<>());
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                buckets[entry.getValue()].add(entry.getKey());
            }
            int[] ans = new int[k];
            for (int i = maxCnt, j = 0; i >= 0 && j < k; i--) {
                for (int x : buckets[i]) {
                    ans[j++] = x;
                }
            }
            return ans;
        }
    }

}
