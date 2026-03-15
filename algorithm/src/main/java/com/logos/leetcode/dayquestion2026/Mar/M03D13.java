package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/13 8:04
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D13 {

    /**
     * 3296. 移山所需的最少秒数
     * <a href="https://leetcode.cn/problems/minimum-number-of-seconds-to-make-mountain-height-zero/description/"/>
     */

    class Solution {
        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
            int maxT = 0;
            for (int t : workerTimes) {
                maxT = Math.max(maxT, t);
            }
            int h = (mountainHeight - 1) / workerTimes.length + 1;
            long left = 0;
            long right = (long) maxT * h * (h + 1) / 2;
            while (left + 1 < right) {
                long mid = (left + right) / 2;
                if (check(mid, mountainHeight, workerTimes)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }

        private boolean check(long m, int leftH, int[] workerTimes) {
            for (int t : workerTimes) {
                leftH -= ((int) Math.sqrt(m / t * 8 + 1) - 1) / 2;
                if (leftH <= 0) {
                    return true;
                }
            }
            return false;
        }
    }

}
