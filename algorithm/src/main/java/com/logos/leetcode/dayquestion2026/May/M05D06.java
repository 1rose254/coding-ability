package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/6 9:35
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D06 {

    /**
     * 1861. 旋转盒子
     * <a href="https://leetcode.cn/problems/rotating-the-box/description/"/>
     */

    class Solution {
        public char[][] rotateTheBox(char[][] boxGrid) {
            int m = boxGrid.length;
            int n = boxGrid[0].length;
            char[][] ans = new char[n][m];
            for (int i = 0; i < m; i++) {
                char[] row = boxGrid[i];
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    char ch = row[j];
                    if (ch == '#') {
                        cnt++;
                        ch = '.';
                    }
                    ans[j][m - 1 - i] = ch;
                    if (j == n - 1 || row[j + 1] == '*') {
                        for (int k = j; k > j - cnt; k--) {
                            ans[k][m - 1 - i] = '#';
                        }
                        cnt = 0;
                    }
                }
            }

            return ans;
        }
    }

}
