package com.logos.leetcode.dayquestion2026.Nov;

import java.util.Arrays;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/5 11:42
 * @version v1.0
 */
public class M11D05 {

    /**
     * 1385. 两个数组间的距离值
     * <a href="https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/description/"/>
     */

    class Solution {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int ans = 0;
            int j = 0;
            for (int x : arr1) {
                while (j < arr2.length && arr2[j] < x - d) {
                    j++;
                }
                if (j == arr2.length || arr2[j] > x + d) {
                    ans++;
                }
            }
            return ans;
        }
    }

}
