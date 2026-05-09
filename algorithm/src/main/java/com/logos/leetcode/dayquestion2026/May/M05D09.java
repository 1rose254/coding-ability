package com.logos.leetcode.dayquestion2026.May;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author logos
 * date 2026/5/9 9:30
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D09 {

    /**
     * 1914. 循环轮转矩阵
     * <a href="https://leetcode.cn/problems/cyclically-rotating-a-grid/description/"/>
     */

    class Solution {
        private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int[][] rotateGrid(int[][] grid, int k) {
            int m0 = grid.length, n0 = grid[0].length;
            List<Integer> a = new ArrayList<>((m0 + n0 - 2) * 2);

            for (int i = 0; i < Math.min(m0, n0) / 2; i++) {
                int m = m0 - i * 2, n = n0 - i * 2;
                int x = i, y = i;
                a.clear();
                for (int[] dir : DIRS) {
                    for (int t = 0; t < n - 1; t++) {
                        a.add(grid[x][y]);
                        x += dir[0];
                        y += dir[1];
                    }
                    int tmp = m;
                    m = n;
                    n = tmp;
                }

                int shift = k % a.size();
                Collections.rotate(a, -shift);

                int j = 0;
                for (int[] dir : DIRS) {
                    for (int t = 0; t < n - 1; t++) {
                        grid[x][y] = a.get(j++);
                        x += dir[0];
                        y += dir[1];
                    }
                    int temp = m;
                    m = n;
                    n = temp;
                }
            }

            return grid;
        }
    }

}
