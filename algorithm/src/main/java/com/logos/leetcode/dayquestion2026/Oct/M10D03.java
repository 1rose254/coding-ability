package com.logos.leetcode.dayquestion2026.Oct;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/3 09:15
 * @version v1.0
 */
public class M10D03 {

    /**
     * 32. 最长有效括号
     * <a href="https://leetcode.cn/problems/longest-valid-parentheses/description/"/>
     */

    class Solution {
        public int longestValidParentheses(String s) {
            List<Integer> st = new ArrayList<>();
            st.add(-1);
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    st.add(i);
                } else if (st.size() > 1) {
                    st.removeLast();
                    ans = Math.max(ans, i - st.getLast());
                } else {
                    st.set(0, i);
                }
            }
            return ans;
        }
    }

}
