package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/19 10:17
 * @version v1.0
 */
public class M09D19 {

    /**
     * 1401. 圆和矩形是否有重叠
     * <a href="https://leetcode.cn/problems/circle-and-rectangle-overlapping/description/"/>
     */

    class Solution {
        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
            int x = Math.max(x1, Math.min(xCenter, x2));
            int y = Math.max(y1, Math.min(yCenter, y2));

            return (x - xCenter) * (x - xCenter) + (y - yCenter) * (y - yCenter) <= radius * radius;
        }
    }

}
