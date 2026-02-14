package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/14 21:43
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D14 {

    /**
     * 799. 香槟塔
     * <a href="https://leetcode.cn/problems/champagne-tower/description/"/>
     */

    class Solution {
        public double champagneTower(int poured, int queryRow, int queryGlass) {
            double[] cur = new double[]{(double) poured};
            for (int i = 1; i <= queryRow; i++) {
                double[] nxt = new double[i + 1];
                for (int j = 0; j < cur.length; j++) {
                    double x = cur[j] - 1;
                    if (x > 0) {
                        nxt[j] += x / 2;
                        nxt[j + 1] += x / 2;
                    }
                }
                cur = nxt;
            }
            return Math.min(cur[queryGlass], 1);
        }
    }

}
