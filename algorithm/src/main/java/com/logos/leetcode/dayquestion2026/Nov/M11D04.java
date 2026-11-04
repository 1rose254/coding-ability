package com.logos.leetcode.dayquestion2026.Nov;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/4 10:56
 * @version v1.0
 */
public class M11D04 {

    /**
     * 3505. 使 K 个子数组内元素相等的最少操作数
     * <a href="https://leetcode.cn/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/description/"/>
     */

    class LazyHeap extends PriorityQueue<Integer> {
        private final Map<Integer, Integer> removeCnt = new HashMap<>();
        private int size = 0;
        private long sum = 0;

        public LazyHeap(Comparator<Integer> comparator) {
            super(comparator);
        }

        public int size() {
            return size;
        }

        public long sum() {
            return sum;
        }

        public void remove(int x) {
            removeCnt.merge(x, 1, Integer::sum);
            size--;
            sum -= x;
        }

        private void applyRemove() {
            while (removeCnt.getOrDefault(peek(), 0) > 0) {
                removeCnt.merge(poll(), -1, Integer::sum);
            }
        }

        public int top() {
            applyRemove();
            return peek();
        }

        public int pop() {
            applyRemove();
            size--;
            sum -= peek();
            return poll();
        }

        public void push(int x) {
            int c = removeCnt.getOrDefault(x, 0);
            if (c > 0) {
                removeCnt.put(x, c - 1);
            } else {
                offer(x);
            }
            size++;
            sum += x;
        }

        public int pushPop(int x) {
            applyRemove();
            sum += x;
            offer(x);
            sum -= peek();
            return poll();
        }
    }

    class Solution {
        public long minOperations(int[] nums, int x, int k) {
            int n = nums.length;
            long[] dis = medianSlidingWindow(nums, x);
            long[][] f = new long[k + 1][n + 1];
            for (int i = 1; i <= k; i++) {
                f[i][i * x - 1] = Long.MAX_VALUE;
                for (int j = i * x; j <= n - (k - i) * x; j++) {
                    f[i][j] = Math.min(f[i][j - 1], f[i - 1][j - x] + dis[j - x]);
                }
            }
            return f[k][n];
        }

        private long[] medianSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            long[] ans = new long[n - k + 1];
            LazyHeap left = new LazyHeap((a, b) -> Integer.compare(b, a));
            LazyHeap right = new LazyHeap(Integer::compare);

            for (int i = 0; i < n; i++) {
                int in = nums[i];
                if (left.size() == right.size()) {
                    left.push(right.pushPop(in));
                } else {
                    right.push(left.pushPop(in));
                }

                int l = i + 1 - k;
                if (l < 0) {
                    continue;
                }

                long v = left.top();
                long s1 = v * left.size() - left.sum();
                long s2 = right.sum() - v * right.size();
                ans[l] = s1 + s2;

                int out = nums[l];
                if (out <= left.top()) {
                    left.remove(out);
                    if (left.size() < right.size()) {
                        left.push(right.pop());
                    }
                } else {
                    right.remove(out);
                    if (left.size() > right.size() + 1) {
                        right.push(left.pop());
                    }
                }
            }
            return ans;
        }
    }

}
