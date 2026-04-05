package com.logos.leetcode.dayquestion2026.Apr;

/**
 * @author logos
 * date 2026/4/5 10:50
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D05 {

    /**
     * 657. 机器人能否返回原点
     * <a href="https://leetcode.cn/problems/robot-return-to-origin/description/"/>
     */

    class Solution {
        public boolean judgeCircle(String moves) {
            int horizontal = 0;
            int vertical = 0;
            for (int i = 0; i < moves.length(); i++) {
                switch (moves.charAt(i)) {
                    case 'L':
                        horizontal--;
                        break;
                    case 'U':
                        vertical++;
                        break;
                    case 'D':
                        vertical--;
                        break;
                    default:
                        horizontal++;
                }
            }
            return horizontal == 0 && vertical == 0;
        }
    }

}
