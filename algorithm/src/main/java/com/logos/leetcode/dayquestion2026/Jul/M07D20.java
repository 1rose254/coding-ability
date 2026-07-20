package com.logos.leetcode.dayquestion2026.Jul;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/7/20 19:52
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D20 {

    /**
     * 1260. 二维网格迁移
     * <a href="https://leetcode.cn/problems/shift-2d-grid/description/"/>
     */

    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            int size = m * n;
            k %= size;
            reverse(grid, n, 0, size - 1);
            reverse(grid, n, 0, k - 1);
            reverse(grid, n, k, size - 1);

            List<List<Integer>> ans = new ArrayList<>(m);
            for (int[] row : grid) {
                List<Integer> r = new ArrayList<>(n);
                for (int x : row) {
                    r.add(x);
                }
                ans.add(r);
            }
            return ans;
        }

        private void reverse(int[][] grid, int n, int l, int r) {
            while (l < r) {
                int x1 = l / n;
                int y1 = l % n;
                int x2 = r / n;
                int y2 = r % n;
                int tmp = grid[x1][y1];
                grid[x1][y1] = grid[x2][y2];
                grid[x2][y2] = tmp;
                l++;
                r--;
            }
        }
    }

}
