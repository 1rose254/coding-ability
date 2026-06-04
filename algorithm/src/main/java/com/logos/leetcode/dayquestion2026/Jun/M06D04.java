package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/4 21:42
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D04 {

    /**
     * 3751. 范围内总波动值 I
     * <a href="https://leetcode.cn/problems/total-waviness-of-numbers-in-range-i/description/"/>
     */

    class Solution {
        public int totalWaviness(int num1, int num2) {
            char[] lowS = Long.toString(num1).toCharArray();
            char[] highS = Long.toString(num2).toCharArray();
            int n = highS.length;
            long[][][][] memo = new long[n][n - 1][3][10];
            return (int) dfs(0, 0, 0, 0, true, true, lowS, highS, memo);
        }

        private long dfs(int i, int waviness, int lastCmp, int lastDigit, boolean limitLow, boolean limitHigh, char[] lowS,
                         char[] highS, long[][][][] memo) {
            if (i == highS.length) {
                return waviness;
            }
            if (!limitLow && !limitHigh && memo[i][waviness][lastCmp + 1][lastDigit] > 0) {
                return memo[i][waviness][lastCmp + 1][lastDigit] - 1;
            }

            int diffLh = highS.length - lowS.length;
            int lo = limitLow && i >= diffLh ? lowS[i - diffLh] - '0' : 0;
            int hi = limitHigh ? highS[i] - '0' : 9;

            long res = 0;
            boolean isNum = !limitLow || i > diffLh;
            for (int d = lo; d <= hi; d++) {
                int cmp = isNum ? Integer.compare(d, lastDigit) : 0;
                int w = waviness + (cmp * lastCmp < 0 ? 1 : 0);
                res += dfs(i + 1, w, cmp, d, limitLow && d == lo, limitHigh && d == hi, lowS, highS, memo);
            }

            if (!limitLow && !limitHigh) {
                memo[i][waviness][lastCmp + 1][lastDigit] = res + 1;
            }
            return res;
        }
    }

}
