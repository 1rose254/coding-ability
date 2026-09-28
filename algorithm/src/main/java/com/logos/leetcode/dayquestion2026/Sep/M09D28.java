package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/28 09:07
 * @version v1.0
 */
public class M09D28 {

    /**
     * 1614. 括号的最大嵌套深度
     * <a href="https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/description/"/>
     */

    class Solution {
        public int maxDepth(String s) {
            int depth = 0;
            int ans = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    depth++;
                    ans = Math.max(ans, depth);
                } else if (ch == ')') {
                    depth--;
                }
            }
            return ans;
        }
    }

}
