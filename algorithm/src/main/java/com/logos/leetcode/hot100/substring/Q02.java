package com.logos.leetcode.hot100.substring;

/**
 * @author logos
 * date 2026/3/5 14:16
 * @version v1.0
 * @Package com.logos.leetcode.hot100.substring
 */
public class Q02 {

    /**
     * 239. 滑动窗口最大值
     */

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] deque = new int[n];
            int l = 0;
            int r = 0;
            for (int i = 0; i < k - 1; i++) {
                while (l < r && nums[deque[r - 1]] <= nums[i]) {
                    r--;
                }
                deque[r++] = i;
            }
            int m = n - k + 1;
            int[] ans = new int[m];
            for (int left = 0, right = k - 1; left < m; left++, right++) {
                while (l < r && nums[deque[r - 1]] <= nums[right]) {
                    r--;
                }
                deque[r++] = right;
                ans[left] = nums[deque[l]];
                if (left == deque[l]) {
                    l++;
                }
            }
            return ans;
        }
    }

}
