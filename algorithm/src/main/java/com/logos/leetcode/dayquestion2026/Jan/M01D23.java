package com.logos.leetcode.dayquestion2026.Jan;

import java.util.PriorityQueue;

/**
 * @author logos
 * date 2026/1/23 23:54
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jan
 */
public class M01D23 {

    /**
     * 3510. 移除最小数对使数组有序 II
     * <a href="https://leetcode.cn/problems/minimum-pair-removal-to-sort-array-ii/description/"/>
     */

    class Solution {
        private record Pair(long s, int i) {
        }

        public int minimumPairRemoval(int[] nums) {
            int n = nums.length;
            PriorityQueue<Pair> h = new PriorityQueue<>((a, b) -> a.s != b.s ? Long.compare(a.s, b.s) : a.i - b.i);
            int dec = 0;
            for (int i = 0; i < n - 1; i++) {
                int x = nums[i];
                int y = nums[i + 1];
                if (x > y) {
                    dec++;
                }
                h.offer(new Pair(x + y, i));
            }

            int[] left = new int[n + 1];
            int[] right = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                left[i] = i - 1;
                right[i] = i + 1;
            }

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nums[i];
            }

            int ans = 0;
            while (dec > 0) {
                ans++;

                while (right[h.peek().i] >= n || h.peek().s != a[h.peek().i] + a[right[h.peek().i]]) {
                    h.poll();
                }

                Pair p = h.poll();
                long s = p.s;
                int i = p.i;

                int nxt = right[i];
                if (a[i] > a[nxt]) {
                    dec--;
                }

                int pre = left[i];
                if (pre >= 0) {
                    if (a[pre] > a[i]) {
                        dec--;
                    }
                    if (a[pre] > s) {
                        dec++;
                    }
                    h.offer(new Pair(a[pre] + s, pre));
                }

                int nxt2 = right[nxt];
                if (nxt2 < n) {
                    if (a[nxt] > a[nxt2]) {
                        dec--;
                    }
                    if (s > a[nxt2]) {
                        dec++;
                    }
                    h.add(new Pair(s + a[nxt2], i));
                }

                a[i] = s;
                int l = left[nxt];
                int r = right[nxt];
                right[l] = r;
                left[r] = l;
                right[nxt] = n;
            }
            return ans;
        }
    }

}
