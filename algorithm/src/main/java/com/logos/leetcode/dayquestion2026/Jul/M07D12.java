package com.logos.leetcode.dayquestion2026.Jul;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/7/12 12:21
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D12 {

    /**
     * 1331. 数组序号转换
     * <a href="https://leetcode.cn/problems/rank-transform-of-an-array/description/"/>
     */

    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            int[] sortedArr = arr.clone();
            Arrays.sort(sortedArr);
            int m = 0;
            for (int x : sortedArr) {
                if (m == 0 || x != sortedArr[m - 1]) {
                    sortedArr[m++] = x;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Arrays.binarySearch(sortedArr, 0, m, arr[i]) + 1;
            }
            return arr;
        }
    }
}
