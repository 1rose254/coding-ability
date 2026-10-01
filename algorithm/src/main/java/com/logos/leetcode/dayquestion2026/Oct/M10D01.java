package com.logos.leetcode.dayquestion2026.Oct;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Package com.logos.leetcode.dayquestion2026.Oct
 * @author logos
 * date 2026/10/1 09:17
 * @version v1.0
 */
public class M10D01 {

    /**
     * 20. 有效的括号
     * <a href="https://leetcode.cn/problems/valid-parentheses/description/"/>
     */

    class Solution {

        private static final HashMap<Character, Character> map = new HashMap<>();

        static {
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
        }

        public boolean isValid(String s) {
            LinkedList<Character> st = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    st.addLast(c);
                } else if (st.isEmpty() || map.get(st.removeLast()) != c) {
                    return false;
                }
            }
            return st.isEmpty();
        }
    }

}
