package com.logos.leetcode.dayquestion2026.Jan;

import java.util.List;

/**
 * @author logos
 * date 2026/1/21 0:17
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jan
 */
public class M01D21 {

    /**
     * 3315. 构造最小位运算数组 II
     * <a href="https://leetcode.cn/problems/construct-the-minimum-bitwise-array-ii/description/"/>
     */
    class Solution {
        public int[] minBitwiseArray(List<Integer> nums) {
            int n = nums.size();
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int x = nums.get(i);
                if (x == 2) {
                    ans[i] = -1;
                } else {
                    int t = ~x;
                    int lowbit = t & -t;
                    ans[i] = x ^ (lowbit >> 1);
                }
            }
            return ans;
        }
    }

}
