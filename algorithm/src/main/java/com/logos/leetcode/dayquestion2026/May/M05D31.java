package com.logos.leetcode.dayquestion2026.May;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/5/31 13:56
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D31 {

    class Solution {
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            Arrays.sort(asteroids);
            long m = mass;
            for (int x : asteroids) {
                if (m < x) {
                    return false;
                }
                m += x;
            }
            return true;
        }
    }

}
