package com.logos.leetcode.dayquestion2026.Nov;

import java.util.Arrays;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/2 11:25
 * @version v1.0
 */
public class M11D02 {

    /**
     * 462. 最小操作次数使数组元素相等 II
     * <a href="https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/description/"/>
     */

    class Solution {
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int mid = nums[(n - 1) / 2];
            int ans = 0;
            for (int i : nums)
                ans += Math.abs(mid - i);
            return ans;
        }
    }

}
