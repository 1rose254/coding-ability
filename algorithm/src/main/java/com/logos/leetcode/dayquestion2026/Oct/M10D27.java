package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/27 10:21
 * @version v1.0
 */
public class M10D27 {

    /**
     * 3963. 构造恰好一条路径的网格
     * <a href="https://leetcode.cn/problems/create-grid-with-exactly-one-path/description/"/>
     */

    class Solution {
        public String[] createGrid(int m, int n) {
            String[] ans = new String[m];
            ans[0] = ".".repeat(n);
            String row = "#".repeat(n - 1) + ".";
            for (int i = 1; i < m; i++) {
                ans[i] = row;
            }
            return ans;
        }
    }

}
