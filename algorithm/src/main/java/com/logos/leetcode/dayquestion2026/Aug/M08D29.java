package com.logos.leetcode.dayquestion2026.Aug;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author logos
 * date 2026/8/29 9:33
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D29 {

    class Solution {
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            int n = nums.length;
            Integer[] pos = new Integer[n];
            Arrays.setAll(pos, i -> i);
            Arrays.sort(pos, Comparator.comparingInt(i -> nums[i]));
            int[] ans = new int[n];
            int start = 0;
            for (int i = 0; i < n; i++) {
                if (i == n - 1 || nums[pos[i + 1]] - nums[pos[i]] > limit) {
                    Integer[] subPos = Arrays.copyOfRange(pos, start, i + 1);
                    Arrays.sort(subPos);
                    for (int j = 0; j < subPos.length; j++) {
                        ans[subPos[j]] = nums[pos[start + j]];
                    }
                    start = i + 1;
                }
            }
            return ans;
        }
    }

}
