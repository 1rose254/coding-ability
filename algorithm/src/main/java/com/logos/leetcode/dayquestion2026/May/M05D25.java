package com.logos.leetcode.dayquestion2026.May;

/**
 * @author logos
 * date 2026/5/25 8:46
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D25 {

    /**
     * 1871. 跳跃游戏 VII
     * <a href="https://leetcode.cn/problems/jump-game-vii/description/"/>
     */

    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            int n = s.length();
            int[] sum = new int[n + 1];
            sum[1] = 1;

            for (int j = 1; j < n; j++) {
                sum[j + 1] = sum[j];
                if (j >= minJump && s.charAt(j) == '0' && sum[j - minJump + 1] > sum[Math.max(j - maxJump, 0)]) {
                    sum[j + 1]++;
                }
            }

            return sum[n] > sum[n - 1];
        }
    }

}
