package com.logos.leetcode.dayquestion2026.Jun;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/6/28 9:51
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D28 {

    /**
     * 1846. 减小和重新排列数组后的最大元素
     * <a href="https://leetcode.cn/problems/maximum-element-after-decreasing-and-rearranging/description/"/>
     */

    class Solution {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            Arrays.sort(arr);
            int n = arr.length;
            arr[0] = 1;
            for (int i = 1; i < n; i++) {
                arr[i] = Math.min(arr[i], arr[i - 1] + 1);
            }
            return arr[n - 1];
        }
    }

}
