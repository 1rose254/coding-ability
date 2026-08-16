package com.logos.leetcode.dayquestion2026.Aug;

/**
 * @author logos
 * date 2026/8/16 11:52
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D16 {

    /**
     * 2029. 石子游戏 IX
     * <a href="https://leetcode.cn/problems/stone-game-ix/description/"/>
     */

    class Solution {
        public boolean stoneGameIX(int[] stones) {
            int[] cnt = new int[3];
            for (int x : stones) {
                cnt[x % 3]++;
            }
            int n = stones.length;
            return check(n, cnt.clone()) || check(n, new int[]{cnt[0], cnt[2], cnt[1]});
        }

        private boolean check(int n, int[] cnt) {
            if (cnt[1] == 0) {
                return false;
            }
            cnt[1]--;
            int rounds = 1 + Math.min(cnt[1], cnt[2]) * 2 + cnt[0];
            if (cnt[1] > cnt[2]) {
                rounds++;
            }
            return rounds < n && rounds % 2 > 0;
        }
    }

}
