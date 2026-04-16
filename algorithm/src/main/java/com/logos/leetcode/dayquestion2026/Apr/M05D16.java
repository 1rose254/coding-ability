package com.logos.leetcode.dayquestion2026.Apr;

import java.util.*;

/**
 * @author logos
 * date 2026/4/16 8:46
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M05D16 {

    /**
     * 3488. 距离最小相等元素查询
     * <a href="https://leetcode.cn/problems/closest-equal-element-queries/description/"/>
     */

    class Solution {
        public List<Integer> solveQueries(int[] nums, int[] queries) {
            Map<Integer, List<Integer>> indices = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                indices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            }

            int n = nums.length;
            for (List<Integer> p : indices.values()) {
                int i0 = p.get(0);
                p.add(0, p.get(p.size() - 1) - n);
                p.add(i0 + n);
            }

            List<Integer> ans = new ArrayList<>(queries.length);
            for (int i : queries) {
                List<Integer> p = indices.get(nums[i]);
                if (p.size() == 3) {
                    ans.add(-1);
                } else {
                    int j = Collections.binarySearch(p, i);
                    ans.add(Math.min(i - p.get(j - 1), p.get(j + 1) - i));
                }
            }
            return ans;
        }
    }

}
