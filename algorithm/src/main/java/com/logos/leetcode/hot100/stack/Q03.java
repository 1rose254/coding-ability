package com.logos.leetcode.hot100.stack;

/**
 * @author logos
 * date 2026/3/9 16:25
 * @version v1.0
 * @Package com.logos.leetcode.hot100.stack
 */
public class Q03 {

    /**
     * 394. 字符串解码
     */

    class Solution {

        private static int where = 0;

        public String decodeString(String s) {
            where = 0;
            return f(0, s.toCharArray());
        }

        private String f(int i, char[] s) {
            int cnt = 0;
            StringBuilder ans = new StringBuilder();
            while (i < s.length && s[i] != ']') {
                if (s[i] >= 'a' && s[i] <= 'z') {
                    ans.append(s[i]);
                } else if (s[i] >= '0' && s[i] <= '9') {
                    cnt = cnt * 10 + s[i] - '0';
                } else {
                    ans.append(get(cnt, f(i + 1, s)));
                    i = where;
                    cnt = 0;
                }
                i++;
            }
            where = i;
            return ans.toString();
        }

        private String get(int cnt, String s) {
            StringBuilder tmp = new StringBuilder();
            for (int k = 0; k < cnt; k++) {
                tmp.append(s);
            }
            return tmp.toString();
        }
    }

}
