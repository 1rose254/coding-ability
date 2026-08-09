package com.logos.leetcode.dayquestion2026.Aug;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author logos
 * date 2026/8/9 10:57
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D09 {

    /**
     * 1140. 石子游戏 II
     * <a href="https://leetcode.cn/problems/stone-game-ii/description/"/>
     */

    class Solution {
        public int stoneGameII(int[] piles) {
            int n = piles.length;
            int[][] f = new int[n][n + 1];
            ArrayDeque<Integer>[] colQ = new ArrayDeque[n + 1];
            Arrays.setAll(colQ, i -> new ArrayDeque<>());
            for (int i = n - 1, s = 0; i >= 0; i--) {
                s += piles[i];
                ArrayDeque<Integer> diagQ = new ArrayDeque<>();
                for (int m = 1; m <= i / 2 + 1; m++) {
                    if (i + m * 2 >= n) {
                        f[i][m] = s;
                        continue;
                    }
                    ArrayDeque<Integer> q = colQ[m];
                    while (!q.isEmpty() && f[q.peekLast()][m] >= f[i + 1][m]) {
                        q.pollLast();
                    }
                    q.offerLast(i + 1);
                    if (q.peekFirst() > i + m) {
                        q.pollFirst();
                    }
                    for (int x = m * 2 - 1; x <= m * 2; x++) {
                        while (!diagQ.isEmpty() && f[i + diagQ.peekLast()][diagQ.peekLast()] >= f[i + x][x]) {
                            diagQ.pollLast();
                        }
                        diagQ.offerLast(x);
                    }
                    if (diagQ.peekFirst() <= m) {
                        diagQ.pollFirst();
                    }

                    f[i][m] = s - Math.min(f[q.peekFirst()][m], f[i + diagQ.peekFirst()][diagQ.peekFirst()]);
                }
            }
            return f[0][1];
        }
    }

}
