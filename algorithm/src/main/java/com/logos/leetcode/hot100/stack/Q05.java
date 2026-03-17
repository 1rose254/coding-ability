package com.logos.leetcode.hot100.stack;

/**
 * @author logos
 * date 2026/3/9 16:44
 * @version v1.0
 * @Package com.logos.leetcode.hot100.stack
 */
public class Q05 {

    /**
     * 84. 柱状图中最大的矩形
     */

    class Solution {
        private static final int MAX_N = 100001;

        private int[] stack = new int[MAX_N];

        private int size;

        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            size = 0;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                while (size > 0 && heights[i] <= heights[stack[size - 1]]) {
                    int cur = stack[--size];
                    int left = size > 0 ? stack[size - 1] : -1;
                    ans = Math.max(ans, (i - left - 1) * heights[cur]);
                }
                stack[size++] = i;
            }
            while (size > 0) {
                int cur = stack[--size];
                int left = size > 0 ? stack[size - 1] : -1;
                ans = Math.max(ans, (n - left - 1) * heights[cur]);
            }
            return ans;
        }
    }

}
