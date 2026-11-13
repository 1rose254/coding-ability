package com.logos.leetcode.dayquestion2026.Nov;

import java.util.*;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/13 12:34
 * @version v1.0
 */
public class M11D13 {

    /**
     * 3420. 统计 K 次操作以内得到非递减子数组的数目
     * <a href="https://leetcode.cn/problems/count-non-decreasing-subarrays-after-k-operations/description/"/>
     */

    class Solution {
        public long countNonDecreasingSubarrays(int[] nums, int k) {
            int n = nums.length;
            List<Integer>[] g = new ArrayList[n];
            Arrays.setAll(g, i -> new ArrayList<>());
            int[] posR = new int[n];
            Arrays.fill(posR, n);
            Deque<Integer> st = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                int x = nums[i];
                while (!st.isEmpty() && x >= nums[st.peek()]) {
                    posR[st.pop()] = i;
                }
                if (!st.isEmpty()) {
                    g[st.peek()].add(i);
                }
                st.push(i);
            }
            long ans = 0;
            int cnt = 0;
            int l = 0;
            Deque<Integer> q = new ArrayDeque<>();
            for (int r = 0; r < n; r++) {
                int x = nums[r];
                while (!q.isEmpty() && nums[q.peekLast()] <= x) {
                    q.pollLast();
                }
                q.addLast(r);
                cnt += nums[q.peekFirst()] - x;
                while (cnt > k) {
                    int out = nums[l];
                    for (int i : g[l]) {
                        if (i > r) {
                            break;
                        }
                        cnt -= (out - nums[i]) * (Math.min(posR[i], r + 1) - i);
                    }
                    l++;
                    if (!q.isEmpty() && q.peekFirst() < l) {
                        q.pollFirst();
                    }
                }
                ans += r - l + 1;
            }
            return ans;
        }
    }

}
