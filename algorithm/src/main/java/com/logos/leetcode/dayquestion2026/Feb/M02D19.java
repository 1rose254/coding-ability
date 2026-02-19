package com.logos.leetcode.dayquestion2026.Feb;

/**
 * @author logos
 * date 2026/2/19 13:15
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D19 {

    /**
     * 696. 计数二进制子串
     * <a href="https://leetcode.cn/problems/count-binary-substrings/description/"/>
     */

    class Solution {
        public int countBinarySubstrings(String S) {
            char[] s = S.toCharArray();
            int n = s.length;
            int pre = 0;
            int cur = 0;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                cur++;
                if (i == n - 1 || s[i] != s[i + 1]) {
                    ans += Math.min(pre, cur);
                    pre = cur;
                    cur = 0;
                }
            }
            return ans;
        }
    }

}
