package com.logos.leetcode.dayquestion2026.Oct;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/24 10:25
 * @version v1.0
 */
public class M10D24 {

    /**
     * 2409. 统计共同度过的日子数
     * <a href="https://leetcode.cn/problems/count-days-spent-together/description/"/>
     */

    class Solution {
        private static final int[] daysPreSum = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

        private int calcDays(String S) {
            char[] s = S.toCharArray();
            int month = (s[0] - '0') * 10 + s[1] - '0';
            int day = (s[3] - '0') * 10 + s[4] - '0';
            return daysPreSum[month - 1] + day;
        }

        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            int left = calcDays(arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob);
            int right = calcDays(leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob);
            return Math.max(right - left + 1, 0);
        }
    }

}
