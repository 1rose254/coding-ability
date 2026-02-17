package com.logos.leetcode.dayquestion2026.Feb;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/2/17 18:08
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D17 {

    /**
     * 401. 二进制手表
     * <a href="https://leetcode.cn/problems/binary-watch/description/"/>
     */

    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> ans = new ArrayList<>();
            for (int h = 0; h < 12; h++) {
                for (int m = 0; m < 60; m++) {
                    if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                        ans.add(String.format("%d:%02d", h, m));
                    }
                }
            }
            return ans;
        }
    }

}
