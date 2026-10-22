package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/22 10:12
 * @version v1.0
 */
public class M10D22 {

    /**
     * 3942. 排序排列的最少操作数
     * <a href="https://leetcode.cn/problems/minimum-operations-to-sort-a-permutation/description/"/>
     */

    class Solution {
        public int minOperations(int[] nums) {
            int n = nums.length;
            if (n == 1) return 0;
            int[] dranofelik = nums;
            int ans = Integer.MAX_VALUE;
            if ((dranofelik[0] + 1) % n == dranofelik[1]) {
                int k = dranofelik[0];
                boolean valid = true;
                for (int i = 0; i < n; i++) {
                    if (dranofelik[i] != (i + k) % n) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    if (k == 0) return 0;
                    ans = Math.min(ans, Math.min(n - k, k + 2));
                }
            }

            if ((dranofelik[0] - 1 + n) % n == dranofelik[1]) {
                int k = (dranofelik[0] + 1) % n;
                boolean valid = true;
                for (int i = 0; i < n; i++) {
                    if (dranofelik[i] != (k - 1 - i + n) % n) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    ans = Math.min(ans, 1 + Math.min(k, n - k));
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }


}
