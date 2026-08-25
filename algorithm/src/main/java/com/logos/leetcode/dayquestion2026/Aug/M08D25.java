package com.logos.leetcode.dayquestion2026.Aug;

import java.util.HashSet;
import java.util.Set;

/**
 * @author logos
 * date 2026/8/25 10:06
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D25 {

    /**
     * 3718. 缺失的最小倍数
     * <a href="https://leetcode.cn/problems/smallest-missing-multiple-of-k/description/"/>
     */

    class Solution {
        public int missingMultiple(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            for (int x : nums) {
                set.add(x);
            }
            for (int x = k; ; x += k) {
                if (!set.contains(x)) {
                    return x;
                }
            }
        }
    }
}
