package com.logos.leetcode.dayquestion2026.Mar;

import java.util.HashSet;
import java.util.Set;

/**
 * @author logos
 * date 2026/3/26 23:32
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D26 {

    /**
     * 3548. 等和矩阵分割 II
     * <a href="https://leetcode.cn/problems/equal-sum-grid-partition-ii/description/"/>
     */

    class Solution {
        public boolean canPartitionGrid(int[][] grid) {
            long total = 0;
            for (int[] row : grid) {
                for (int x : row) {
                    total += x;
                }
            }

            return check(grid, total) || check(rotate(grid), total);
        }

        private boolean check(int[][] a, long total) {
            if (f(a, total)) {
                return true;
            }
            reverse(a);
            return f(a, total);
        }

        private boolean f(int[][] a, long total) {
            int m = a.length, n = a[0].length;
            Set<Long> st = new HashSet<>();
            st.add(0L);
            long s = 0;
            for (int i = 0; i < m - 1; i++) {
                int[] row = a[i];
                for (int j = 0; j < n; j++) {
                    int x = row[j];
                    s += x;
                    if (i > 0 || j == 0 || j == n - 1) {
                        st.add((long) x);
                    }
                }
                if (n == 1) {
                    if (s * 2 == total || s * 2 - total == a[0][0] || s * 2 - total == row[0]) {
                        return true;
                    }
                    continue;
                }
                if (st.contains(s * 2 - total)) {
                    return true;
                }
                if (i == 0) {
                    for (int x : row) {
                        st.add((long) x);
                    }
                }
            }
            return false;
        }

        private int[][] rotate(int[][] a) {
            int m = a.length, n = a[0].length;
            int[][] b = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    b[j][m - 1 - i] = a[i][j];
                }
            }
            return b;
        }

        private void reverse(int[][] a) {
            for (int i = 0, j = a.length - 1; i < j; i++, j--) {
                int[] tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
    }

}
