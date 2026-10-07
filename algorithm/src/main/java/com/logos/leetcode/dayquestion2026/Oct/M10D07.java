package com.logos.leetcode.dayquestion2026.Oct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/7 10:18
 * @version v1.0
 */
public class M10D07 {

    /**
     * 301. 删除无效的括号
     * <a href="https://leetcode.cn/problems/remove-invalid-parentheses/description/"/>
     */

    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            ArrayList<String> ans = new ArrayList<>();
            HashSet<String> cur = new HashSet<>();
            cur.add(s);
            while (true) {
                for (String t : cur) {
                    if (isValid(t)) {
                        ans.add(t);
                    }
                }
                if (!ans.isEmpty()) {
                    return ans;
                }
                HashSet<String> nxt = new HashSet<>();
                for (String t : cur) {
                    for (int i = 0; i < t.length(); i++) {
                        char ch = t.charAt(i);
                        if (ch == '(' || ch == ')') {
                            nxt.add(t.substring(0, i) + t.substring(i + 1));
                        }
                    }
                }
                cur = nxt;
            }
        }

        private boolean isValid(String s) {
            int left = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    left++;
                } else if (ch == ')') {
                    if (left == 0) {
                        return false;
                    }
                    left--;
                }
            }
            return left == 0;
        }
    }

}
