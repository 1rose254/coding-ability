package com.logos.leetcode.dayquestion2026.Aug;

/**
 * @author logos
 * date 2026/8/23 11:56
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D23 {

    /**
     * 1927. 求和游戏
     * <a href="https://leetcode.cn/problems/sum-game/description/"/>
     */

    class Solution {
        public boolean sumGame(String num) {
            char[] s = num.toCharArray();
            int n = s.length;
            int d = 0;
            for (int i = 0; i < n; i++) {
                int x = s[i] == '?' ? 9 : (s[i] - '0') * 2;
                d += i < n / 2 ? x : -x;
            }
            return d != 0;
        }
    }

}
