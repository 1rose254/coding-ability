package com.logos.leetcode.dayquestion2026.Feb;

import java.util.Arrays;

/**
 * @author logos
 * date 2026/2/25 0:38
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D25 {

    /**
     * 1356. 根据数字二进制下 1 的数目排序
     * <a href="https://leetcode.cn/problems/sort-integers-by-the-number-of-1-bits/description/"/>
     */

    class Solution {
        public int[] sortByBits(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.bitCount(arr[i]) << 16 | arr[i];
            }
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                arr[i] &= 0xffff;
            }
            return arr;
        }
    }

}
