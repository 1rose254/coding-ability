package com.logos.leetcode.dayquestion2026.Apr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author logos
 * date 2026/4/10 12:50
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D10 {

    /**
     * 3740. 三个相等元素之间的最小距离 I
     * <a href="https://leetcode.cn/problems/minimum-distance-between-three-equal-elements-i/description/"/>
     */

    class Solution {
        public int minimumDistance(int[] nums) {
            Map<Integer, List<Integer>> pos = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                pos.computeIfAbsent(nums[i], tmp -> new ArrayList<>()).add(i);
            }

            int ans = Integer.MAX_VALUE;
            for (List<Integer> p : pos.values()) {
                for (int i = 2; i < p.size(); i++) {
                    ans = Math.min(ans, (p.get(i) - p.get(i - 2)) * 2);
                }
            }

            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }

}
