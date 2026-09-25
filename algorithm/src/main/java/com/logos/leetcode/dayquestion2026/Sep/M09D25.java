package com.logos.leetcode.dayquestion2026.Sep;

import java.util.*;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/25 09:53
 * @version v1.0
 */
public class M09D25 {

    /**
     * 1096. 花括号展开 II
     * <a href="https://leetcode.cn/problems/brace-expansion-ii/description/"/>
     */

    class Solution {
        private int i = 0;

        public List<String> braceExpansionII(String expression) {
            char[] s = expression.toCharArray();
            List<String> ans = new ArrayList<>(dfs(s));
            Collections.sort(ans);
            return ans;
        }

        private Set<String> dfs(char[] expression) {
            Set<String> res = new HashSet<>();
            Set<String> cur = new HashSet<>();
            cur.add("");
            while (i < expression.length) {
                char ch = expression[i];
                i++;

                if (ch == '}') {
                    break;
                }
                if (ch == ',') {
                    res.addAll(cur);
                    cur.clear();
                    cur.add("");
                } else if (ch == '{') {
                    Set<String> subRes = dfs(expression);
                    Set<String> newSet = new HashSet<>();
                    for (String s : cur) {
                        for (String t : subRes) {
                            newSet.add(s + t);
                        }
                    }
                    cur = newSet;
                } else {
                    Set<String> newSet = new HashSet<>();
                    for (String s : cur) {
                        newSet.add(s + ch);
                    }
                    cur = newSet;
                }
            }
            res.addAll(cur);
            return res;
        }
    }

}
