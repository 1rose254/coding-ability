package com.logos.leetcode.dayquestion2026.Apr;

/**
 * @author logos
 * date 2026/4/24 10:35
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D24 {

    /**
     * 2833. 距离原点最远的点
     * <a href="https://leetcode.cn/problems/furthest-point-from-origin/description/"/>
     */

    class Solution {
        public int furthestDistanceFromOrigin(String moves) {
            int cntR = 0;
            int cntL = 0;
            for (char c : moves.toCharArray()) {
                if (c == 'R') {
                    cntR++;
                } else if (c == 'L') {
                    cntL++;
                }
            }
            return Math.abs(cntR - cntL) + moves.length() - cntR - cntL;
        }
    }

}
