package com.logos.leetcode.dayquestion2026.Jun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/6/8 9:08
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D08 {

    /**
     * 2161. 根据给定数字划分数组
     * <a href="https://leetcode.cn/problems/partition-array-according-to-given-pivot/description/"/>
     */

    class Solution {
        public int[] pivotArray(int[] nums, int pivot) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            List<Integer> c = new ArrayList<>();
            for (int x : nums) {
                if (x < pivot) {
                    a.add(x);
                } else if (x == pivot) {
                    b.add(x);
                } else {
                    c.add(x);
                }
            }
            int[] ans = new int[nums.length];
            int idx = 0;
            for (int x : a) ans[idx++] = x;
            for (int x : b) ans[idx++] = x;
            for (int x : c) ans[idx++] = x;
            return ans;
        }
    }

}
