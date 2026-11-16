package com.logos.leetcode.dayquestion2026.Nov;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/16 11:14
 * @version v1.0
 */
public class M11D16 {

    /**
     * 2243. 计算字符串的数字和
     * <a href="https://leetcode.cn/problems/calculate-digit-sum-of-a-string/description/"/>
     */

    class Solution {
        public String digitSum(String s, int k) {
            while (s.length() > k) {
                int n = s.length();
                StringBuilder t = new StringBuilder();
                for (int i = 0; i < n; i += k) {
                    int sum = 0;
                    for (int j = i; j < Math.min(i + k, n); j++) {
                        sum += s.charAt(j) - '0';
                    }
                    t.append(sum);
                }
                s = t.toString();
            }
            return s;
        }
    }

}
