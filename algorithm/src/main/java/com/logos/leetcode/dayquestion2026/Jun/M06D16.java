package com.logos.leetcode.dayquestion2026.Jun;

/**
 * @author logos
 * date 2026/6/16 22:25
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D16 {
    /**
     * 3612. 用特殊操作处理字符串 I
     * <a href="https://leetcode.cn/problems/process-string-with-special-operations-i/description/"/>
     */

    class Solution {
        String processStr(String s) {
            StringBuilder ans = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '*') {
                    if (!ans.isEmpty()) {
                        ans.setLength(ans.length() - 1);
                    }
                } else if (c == '#') {
                    ans.append(ans);
                } else if (c == '%') {
                    ans.reverse();
                } else {
                    ans.append(c);
                }
            }
            return ans.toString();
        }
    }

}
