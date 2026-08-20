package com.logos.leetcode.dayquestion2026.Aug;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/8/20 11:20
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D20 {

    /**
     * 3069. 将元素分配到两个数组中 I
     * <a href="https://leetcode.cn/problems/distribute-elements-into-two-arrays-i/description/"/>
     */

    class Solution {
        public int[] resultArray(int[] nums) {
            int n = nums.length;
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            a.add(nums[0]);
            b.add(nums[1]);
            for (int i = 2; i < n; i++) {
                if (a.get(a.size() - 1) > b.get(b.size() - 1)) {
                    a.add(nums[i]);
                } else {
                    b.add(nums[i]);
                }
            }
            a.addAll(b);
            for (int i = 0; i < n; i++) {
                nums[i] = a.get(i);
            }
            return nums;
        }
    }

}
