package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/18 12:42
 * @version v1.0
 */
public class M11D18 {

    /**
     * 2914. 使二进制字符串变美丽的最少修改次数
     * <a href="https://leetcode.cn/problems/minimum-number-of-changes-to-make-binary-string-beautiful/description/"/>
     */

    class Solution {
        public int minChanges(String S) {
            char[] s = S.toCharArray();
            int ans = 0;
            for (int i = 0; i < s.length; i += 2) {
                if (s[i] != s[i + 1]) {
                    ans++;
                }
            }
            return ans;
        }
    }

}
