package com.logos.leetcode.dayquestion2026.May;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author logos
 * date 2026/5/18 8:03
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D18 {

    /**
     * 1345. 跳跃游戏 IV
     * <a href="https://leetcode.cn/problems/jump-game-iv/description/"/>
     */

    class Solution {
        public int minJumps(int[] arr) {
            int n = arr.length;
            Map<Integer, List<Integer>> pos = new HashMap<>();
            for (int i = 0; i < n; i++) {
                pos.computeIfAbsent(arr[i], tmp -> new ArrayList<>()).add(i);
            }

            boolean[] vis = new boolean[n];
            vis[0] = true;
            List<Integer> q = List.of(0);

            for (int ans = 0; ; ans++) {
                List<Integer> tmp = q;
                q = new ArrayList<>();
                for (int i : tmp) {
                    if (i == n - 1) {
                        return ans;
                    }

                    if (!vis[i + 1]) {
                        vis[i + 1] = true;
                        q.add(i + 1);
                    }

                    if (i > 0 && !vis[i - 1]) {
                        vis[i - 1] = true;
                        q.add(i - 1);
                    }

                    int x = arr[i];
                    List<Integer> idx = pos.get(x);
                    if (idx == null) {
                        continue;
                    }
                    for (int j : idx) {
                        if (!vis[j]) {
                            vis[j] = true;
                            q.add(j);
                        }
                    }
                    pos.remove(x);
                }
            }
        }
    }

}
