package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/3 21:03
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D03 {

    /**
     * 3635. 最早完成陆地和水上游乐设施的时间 II
     * <a href="https://leetcode.cn/problems/earliest-finish-time-for-land-and-water-rides-ii/description/"/>
     */

    class Solution {
        public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
            int landWater = solve(landStartTime, landDuration, waterStartTime, waterDuration);
            int waterLand = solve(waterStartTime, waterDuration, landStartTime, landDuration);
            return Math.min(landWater, waterLand);
        }

        private int solve(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
            int minFinish = Integer.MAX_VALUE;
            for (int i = 0; i < landStartTime.length; i++) {
                minFinish = Math.min(minFinish, landStartTime[i] + landDuration[i]);
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < waterStartTime.length; i++) {
                res = Math.min(res, Math.max(waterStartTime[i], minFinish) + waterDuration[i]);
            }
            return res;
        }
    }

}
