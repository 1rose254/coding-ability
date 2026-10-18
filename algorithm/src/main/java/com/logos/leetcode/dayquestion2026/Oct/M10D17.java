package com.logos.leetcode.dayquestion2026.Oct;

import java.util.Arrays;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/18 11:33
 * @version v1.0
 */
public class M10D17 {

    /**
     * 3551. 数位和排序需要的最小交换次数
     * <a href="https://leetcode.cn/problems/minimum-swaps-to-sort-by-digit-sum/description/"/>
     */

    class UnionFind {
        private final int[] fa;
        public int cc;

        UnionFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            cc = n;
        }

        public int find(int x) {
            if (fa[x] != x) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        public void merge(int from, int to) {
            int x = find(from);
            int y = find(to);
            if (x == y) {
                return;
            }
            fa[x] = y;
            cc--;
        }
    }

    class Solution {
        public int minSwaps(int[] nums) {
            int n = nums.length;
            int[][] a = new int[n][3];
            for (int i = 0; i < n; i++) {
                int s = 0;
                for (int x = nums[i]; x > 0; x /= 10) {
                    s += x % 10;
                }
                a[i][0] = s;
                a[i][1] = nums[i];
                a[i][2] = i;
            }

            Arrays.sort(a, (p, q) -> p[0] != q[0] ? p[0] - q[0] : p[1] - q[1]);

            UnionFind u = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                u.merge(i, a[i][2]);
            }
            return n - u.cc;
        }
    }

}
