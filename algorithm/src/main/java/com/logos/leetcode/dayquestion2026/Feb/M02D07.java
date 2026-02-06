package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/7 0:45
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D07 {

    /**
     * 1653. 使字符串平衡的最少删除次数
     * <a href="https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/description/"/>
     */

    class Solution {
        public int minimumDeletions(String S) {
            char[] s = S.toCharArray();
            int del = 0;
            for (char c : s) {
                del += 'b' - c;
            }
            int ans = del;
            for (char c : s) {
                del += (c - 'a') * 2 - 1;
                ans = Math.min(ans, del);
            }
            return ans;
        }
    }

}
