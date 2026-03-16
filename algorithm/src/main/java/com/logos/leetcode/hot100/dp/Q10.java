package com.logos.leetcode.hot100.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logos
 * date 2026/3/16 17:09
 * @version v1.0
 * @Package com.logos.leetcode.hot100.dp
 */
public class Q10 {

    /**
     * 32. 最长有效括号
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
