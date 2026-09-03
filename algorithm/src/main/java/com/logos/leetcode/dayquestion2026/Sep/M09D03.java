package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @author logos
 * date 2026/9/3 10:28
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Sep
 */
public class M09D03 {

    /**
     * 3876. 构造奇偶一致的数组 II
     * <a href="https://leetcode.cn/problems/construct-uniform-parity-array-ii/description/"/>
     */

    class Solution {
        public boolean uniformArray(int[] nums1) {
            int[] mn = {Integer.MAX_VALUE, Integer.MAX_VALUE};
            for (int x : nums1) {
                mn[x & 1] = Math.min(mn[x & 1], x);
            }
            return mn[1] == Integer.MAX_VALUE || mn[0] > mn[1];
        }
    }

}
