package com.logos.leetcode.dayquestion2026.Aug;

/**
 * @author logos
 * date 2026/8/24 9:30
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D24 {

    /**
     * 1872. 石子游戏 VIII
     * <a href="https://leetcode.cn/problems/stone-game-viii/description/"/>
     */

    class Solution {
        public int stoneGameVIII(int[] stones) {
            int sum = 0;
            for (int x : stones) {
                sum += x;
            }
            int f = sum;
            for (int i = stones.length - 2; i > 0; i--) {
                sum -= stones[i + 1];
                f = Math.max(f, sum - f);
            }
            return f;
        }
    }

}
