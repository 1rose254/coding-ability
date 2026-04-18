package com.logos.leetcode.dayquestion2026.Apr;

/**
 * @author logos
 * date 2026/4/18 10:03
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Apr
 */
public class M04D18 {

    /**
     * 3783. 整数的镜像距离
     * <a href="https://leetcode.cn/problems/mirror-distance-of-an-integer/description/"/>
     */

    class Solution {
        public int mirrorDistance(int n) {
            int rev = 0;
            for (int x = n; x > 0; x /= 10) {
                rev = rev * 10 + x % 10;
            }
            return Math.abs(n - rev);
        }
    }

}
