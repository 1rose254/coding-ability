package com.logos.leetcode.hot100.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/5 21:29
 * @version v1.0
 * @Package com.logos.leetcode.hot100.matrix
 */
public class Q02 {

    /**
     * 54. 螺旋矩阵
     */

    class Solution {
        private static final int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        private static final int INF = -101;

        public List<Integer> spiralOrder(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            List<Integer> ans = new ArrayList<>(n * m);
            for (int x = 0, y = 0, nx = 0, ny = 0, d = 0, i = 0; i < n * m; i++) {
                ans.add(matrix[x][y]);
                matrix[x][y] = INF;
                nx = x + dir[d][0];
                ny = y + dir[d][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || matrix[nx][ny] == INF) {
                    d = (d + 1) % 4;
                    nx = x + dir[d][0];
                    ny = y + dir[d][1];
                }
                x = nx;
                y = ny;
            }
            return ans;
        }
    }

}
