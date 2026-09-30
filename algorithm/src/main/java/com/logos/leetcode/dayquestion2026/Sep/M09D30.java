package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/30 10:35
 * @version v1.0
 */
public class M09D30 {

    /**
     * 1111. 有效括号的嵌套深度
     * <a href="https://leetcode.cn/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/description/"/>
     */

    class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            char[] s = seq.toCharArray();
            int[] ans = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                if (s[i] == '(') {
                    ans[i] = i % 2;
                } else {
                    ans[i] = (i + 1) % 2;
                }
            }
            return ans;
        }
    }

}
