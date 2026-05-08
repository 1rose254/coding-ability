package com.logos.leetcode.dayquestion2026.May;

import java.util.*;

/**
 * @author logos
 * date 2026/5/8 9:28
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D08 {

    /**
     * 3629. 通过质数传送到达终点的最少跳跃次数
     * <a href="https://leetcode.cn/problems/minimum-jumps-to-reach-end-via-prime-teleportation/description/"/>
     */

    class Solution {
        private static final int MX = 1_000_001;
        private static final List<Integer>[] primeFactors = new ArrayList[MX];
        private static boolean initialized = false;

        private void init() {
            if (initialized) {
                return;
            }
            initialized = true;

            Arrays.setAll(primeFactors, i -> new ArrayList<>());
            for (int i = 2; i < MX; i++) {
                if (primeFactors[i].isEmpty()) {
                    for (int j = i; j < MX; j += i) {
                        primeFactors[j].add(i);
                    }
                }
            }
        }

        public int minJumps(int[] nums) {
            init();

            int n = nums.length;
            Map<Integer, List<Integer>> groups = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int p : primeFactors[nums[i]]) {
                    groups.computeIfAbsent(p, tmp -> new ArrayList<>()).add(i);
                }
            }

            int ans = 0;
            boolean[] vis = new boolean[n];
            vis[0] = true;
            List<Integer> q = List.of(0);

            while (true) {
                List<Integer> tmp = q;
                q = new ArrayList<>();
                for (int i : tmp) {
                    if (i == n - 1) {
                        return ans;
                    }
                    List<Integer> idx = groups.computeIfAbsent(nums[i], k -> new ArrayList<>());
                    idx.add(i + 1);
                    if (i > 0) {
                        idx.add(i - 1);
                    }
                    for (int j : idx) {
                        if (!vis[j]) {
                            vis[j] = true;
                            q.add(j);
                        }
                    }
                    idx.clear();
                }
                ans++;
            }
        }
    }

}
