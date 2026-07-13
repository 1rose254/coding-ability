package com.logos.leetcode.dayquestion2026.Jul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author logos
 * date 2026/7/13 19:36
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D13 {

    /**
     * 1291. 顺次数
     * <a href="https://leetcode.cn/problems/sequential-digits/description/"/>
     */

    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> ans = new ArrayList<>();
            for (int d = 1; d <= 9; d++) {
                int x = d;
                for (int i = d; i <= 9 && x <= high; i++) {
                    if (x >= low) {
                        ans.add(x);
                    }
                    x = x * 10 + i + 1;
                }
            }
            Collections.sort(ans);
            return ans;
        }
    }

}
