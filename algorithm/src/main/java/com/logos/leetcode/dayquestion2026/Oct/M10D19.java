package com.logos.leetcode.dayquestion2026.Oct;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/19 09:31
 * @version v1.0
 */
public class M10D19 {

    /**
     * 2089. 找出数组排序后的目标下标
     * <a href="https://leetcode.cn/problems/find-target-indices-after-sorting-array/description/"/>
     */

    class Solution {
        public List<Integer> targetIndices(int[] nums, int target) {
            int less = 0;
            int equal = 0;
            for (int x : nums) {
                if (x < target) {
                    less++;
                } else if (x == target) {
                    equal++;
                }
            }
            List<Integer> ans = new ArrayList<>(equal);
            for (int i = 0; i < equal; i++) {
                ans.add(less + i);
            }
            return ans;
        }
    }

}
