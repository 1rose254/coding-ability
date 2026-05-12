package com.logos.leetcode.dayquestion2026.May;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/5/12 9:49
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D12 {

    /**
     * 1665. 完成所有任务的最少初始能量
     * <a href="https://leetcode.cn/problems/minimum-initial-energy-to-finish-tasks/description/"/>
     */

    class Solution {
        public int minimumEffort(int[][] tasks) {
            Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

            int ans = 0;
            int s = 0;
            for (int[] t : tasks) {
                int actual = t[0];
                int minimum = t[1];
                ans = Math.max(ans, s + minimum);
                s += actual;
            }
            return ans;
        }
    }

}
