package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/26 11:57
 * @version v1.0
 */
public class M11D26 {

    /**
     * 3360. 移除石头游戏
     * <a href="https://leetcode.cn/problems/stone-removal-game/description/"/>
     */

    class Solution {
        public boolean canAliceWin(int n) {
            int x = (21 - (int) Math.ceil(Math.sqrt(441 - n * 8))) / 2;
            return x % 2 > 0;
        }
    }

}
