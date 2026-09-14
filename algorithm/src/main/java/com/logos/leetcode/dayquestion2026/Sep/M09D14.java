package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/14 10:17
 * @version v1.0
 */
public class M09D14 {

    /**
     * 836. 矩形重叠
     * <a href="https://leetcode.cn/problems/rectangle-overlap/description/"/>
     */

    class Solution {
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            return isIntervalOverlap(rec1[0], rec1[2], rec2[0], rec2[2]) &&
                    isIntervalOverlap(rec1[1], rec1[3], rec2[1], rec2[3]);
        }

        private boolean isIntervalOverlap(int l1, int r1, int l2, int r2) {
            return r1 > l2 && r2 > l1;
        }
    }

}
