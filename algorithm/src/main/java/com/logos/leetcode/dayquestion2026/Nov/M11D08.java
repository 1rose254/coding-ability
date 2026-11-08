package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/8 12:35
 * @version v1.0
 */
public class M11D08 {

    /**
     * 1267. 统计参与通信的服务器
     * <a href="https://leetcode.cn/problems/count-servers-that-communicate/description/"/>
     */

    class Solution {
        public int countServers(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] rowCnt = new int[m];
            int[] colCnt = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > 0) {
                        rowCnt[i]++;
                        colCnt[j]++;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > 0 && (rowCnt[i] > 1 || colCnt[j] > 1)) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

}
