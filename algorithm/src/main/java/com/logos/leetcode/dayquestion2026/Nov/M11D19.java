package com.logos.leetcode.dayquestion2026.Nov;

import java.util.Arrays;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/19 12:03
 * @version v1.0
 */
public class M11D19 {

    /**
     * 2567. 修改两个元素的最小分数
     * <a href="https://leetcode.cn/problems/minimum-score-by-changing-two-elements/description/"/>
     */

    class Solution {
        public int minimizeSum(int[] a) {
            Arrays.sort(a);
            int n = a.length;
            return Math.min(Math.min(a[n - 3] - a[0], a[n - 2] - a[1]), a[n - 1] - a[2]);
        }
    }

}
