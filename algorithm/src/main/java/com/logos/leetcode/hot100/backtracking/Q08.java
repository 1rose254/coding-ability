package com.logos.leetcode.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/8 15:26
 * @version v1.0
 * @Package com.logos.leetcode.hot100.backtracking
 */
public class Q08 {

    /**
     * 51. N 皇后
     */

    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> ans = new ArrayList<>();
            int limit = (1 << n) - 1;
            f(limit, 0, 0, 0, 0, new int[n], ans);
            return ans;
        }

        private void f(int limit, int col, int left, int right, int row, int[] path, List<List<String>> ans) {
            if (col == limit) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < path.length; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < path.length; j++) {
                        sb.append(path[i] == j ? 'Q' : '.');
                    }
                    list.add(sb.toString());
                }
                ans.add(list);
                return;
            }
            int ban = col | left | right;
            int can = limit & (~ban);
            while (can != 0) {
                int place = can & (-can);
                can ^= place;
                int colIndex = Integer.numberOfTrailingZeros(place);
                path[row] = colIndex;
                f(limit, col | place, (left | place) << 1, (right | place) >> 1, row + 1, path, ans);
            }
        }
    }

}
