package com.logos.leetcode.dayquestion2026.Aug;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logos
 * date 2026/8/19 10:59
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D19 {

    /**
     * 1386. 安排电影院座位
     * <a href="https://leetcode.cn/problems/cinema-seat-allocation/description/"/>
     */

    class Solution {
        public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
            Map<Integer, Integer> seats = new HashMap<>();
            for (int[] r : reservedSeats) {
                int seat = r[1];
                if (2 <= seat && seat <= 9) {
                    seats.merge(r[0], 1 << (seat - 2), (a, b) -> a | b);
                }
            }
            int emptyRows = n - seats.size();
            int ans = emptyRows * 2;
            for (int x : seats.values()) {
                if ((x & 0b1111) == 0 || (x & 0b111100) == 0 || (x & 0b11110000) == 0) {
                    ans++;
                }
            }
            return ans;
        }
    }

}
