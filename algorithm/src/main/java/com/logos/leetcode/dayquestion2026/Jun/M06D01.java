package com.logos.leetcode.dayquestion2026.Jun;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/6/1 9:42
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D01 {

    class Solution {
        public int minimumCost(int[] cost) {
            Arrays.sort(cost);
            int ans = 0;
            for (int i = cost.length - 1; i >= 0; i -= 3) {
                ans += cost[i];
                if (i > 0) {
                    ans += cost[i - 1];
                }
            }
            return ans;
        }
    }

}
