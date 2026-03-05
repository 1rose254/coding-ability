package com.logos.leetcode.hot100.normal_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logos
 * date 2026/3/5 14:33
 * @version v1.0
 * @Package com.logos.leetcode.hot100.normal_array
 */
public class Q02 {

    /**
     * 56. 合并区间
     */

    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> ans = new ArrayList<>();
            Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
            int n = intervals.length;
            int preIndex = 0;
            int preLast = intervals[0][1];
            for (int i = 1; i < n; i++) {
                if (preLast < intervals[i][0]) {
                    ans.add(new int[]{intervals[preIndex][0], preLast});
                    preIndex = i;
                    preLast = intervals[i][1];
                } else {
                    preLast = Math.max(preLast, intervals[i][1]);
                }
            }
            ans.add(new int[]{intervals[preIndex][0], preLast});
            return ans.toArray(new int[ans.size()][]);
        }
    }

}
