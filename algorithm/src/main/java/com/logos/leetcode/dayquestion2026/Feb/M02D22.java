package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/22 0:11
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D22 {

    /**
     * 868. 二进制间距
     * <a href="https://leetcode.cn/problems/binary-gap/description/"/>
     */

    class Solution {
        public int binaryGap(int n) {
            int ans = 0;
            for (int i = 31, j = -1; i >= 0; i--) {
                if (((n >> i) & 1) == 1) {
                    if (j != -1) {
                        ans = Math.max(ans, j - i);
                    }
                    j = i;
                }
            }
            return ans;
        }
    }

}
