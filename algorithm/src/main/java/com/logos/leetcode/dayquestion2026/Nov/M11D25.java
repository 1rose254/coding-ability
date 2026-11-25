package com.logos.leetcode.dayquestion2026.Nov;

import java.util.HashMap;
import java.util.Random;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/25 13:41
 * @version v1.0
 */
public class M11D25 {

    /**
     * 3934. 最短唯一子数组
     * <a href="https://leetcode.cn/problems/smallest-unique-subarray/description/"/>
     */

    class Solution {
        private static final int MOD = 1_070_777_777;
        private static final int BASE = (int) 8e8 + new Random().nextInt((int) 1e8);

        private int[] powBase;
        private int[] preHash;

        private int subHash(int l, int r) {
            return (int) ((preHash[r] - (long) preHash[l] * powBase[r - l] % MOD + MOD) % MOD);
        }

        public int smallestUniqueSubarray(int[] nums) {
            int n = nums.length;
            powBase = new int[n + 1];
            preHash = new int[n + 1];
            powBase[0] = 1;
            for (int i = 0; i < n; i++) {
                powBase[i + 1] = (int) ((long) powBase[i] * BASE % MOD);
                preHash[i + 1] = (int) (((long) preHash[i] * BASE + nums[i]) % MOD);
            }

            int left = 0;
            int right = n;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (check(mid, n)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }

        private boolean check(int length, int n) {
            HashMap<Integer, Integer> cnt = new HashMap<>();
            for (int i = length; i <= n; i++) {
                int h = subHash(i - length, i);
                cnt.merge(h, 1, Integer::sum);
            }
            return cnt.containsValue(1);
        }
    }

}
