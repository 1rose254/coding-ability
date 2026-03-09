package com.logos.leetcode.hot100.stack;

import java.util.*;

/**
 * @author logos
 * date 2026/3/9 16:07
 * @version v1.0
 * @Package com.logos.leetcode.hot100.stack
 */
public class Q01 {

    /**
     * 20. 有效的括号
     */

    class Solution {
        private static Map<Character, Character> map = new HashMap<>();

        static {
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
        }

        public boolean isValid(String s) {
            List<Character> st = new LinkedList<>();
            for (Character c : s.toCharArray()) {
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
