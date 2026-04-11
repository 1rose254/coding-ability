package com.logos.leetcode.dayquestion2026.Apr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author logos
 * date 2026/4/11 8:44
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D11 {

    /**
     * 3741. 三个相等元素之间的最小距离 II
     * <a href="https://leetcode.cn/problems/minimum-distance-between-three-equal-elements-ii/description/"/>
     */

    class Solution {
        public int minimumDistance(int[] nums) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.computeIfAbsent(nums[i], tmp -> new ArrayList<>()).add(i);
            }
            int ans = Integer.MAX_VALUE;
            for (List<Integer> list : map.values()) {
                for (int i = 2; i < list.size(); i++) {
                    ans = Math.min(ans, (list.get(i) - list.get(i - 2)) * 2);
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }

}
