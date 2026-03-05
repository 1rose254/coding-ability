package com.logos.leetcode.dayquestion2026.Mar;

/**
 * @author logos
 * date 2026/3/5 9:53
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M03D05 {

    /**
     * 1758. 生成交替二进制字符串的最少操作数
     * <a href="https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/description/"/>
     */

    class Solution {
        public int minOperations(String s) {
            int ans = 0;
            char[] sArr = s.toCharArray();
            int n = sArr.length;
            for (int i = 1; i < n; i++) {
                if (sArr[i] == sArr[i - 1]) {
                    sArr[i] = sArr[i] == '1' ? '0' : '1';
                    ans++;
                }
            }
            return Math.min(ans, n - ans);
        }
    }

}
