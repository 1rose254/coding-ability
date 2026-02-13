package com.logos.leetcode.dayquestion2026.Feb;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logos
 * date 2026/2/13 9:11
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Feb
 */
public class M02D13 {

    /**
     * 3714. 最长的平衡子串 II
     * <a href="https://leetcode.cn/problems/longest-balanced-substring-ii/description/"/>
     */

    class Solution {
        public int longestBalanced(String S) {
            char[] s = S.toCharArray();
            int n = s.length;
            int ans = 0;
            for (int i = 0; i < n; ) {
                int start = i;
                for (i++; i < n && s[i] == s[i - 1]; i++)
                    ;
                ans = Math.max(ans, i - start);
            }
            ans = Math.max(ans, f(s, 'a', 'b'));
            ans = Math.max(ans, f(s, 'a', 'c'));
            ans = Math.max(ans, f(s, 'b', 'c'));
            Map<Long, Integer> pos = new HashMap<>();
            pos.put((long) n << 20 | n, -1);
            int[] cnt = new int[3];
            for (int i = 0; i < n; i++) {
                cnt[s[i] - 'a']++;
                long p = (long) (cnt[0] - cnt[1] + n) << 20 | (cnt[1] - cnt[2] + n);
                if (pos.containsKey(p)) {
                    ans = Math.max(ans, i - pos.get(p));
                } else {
                    pos.put(p, i);
                }
            }
            return ans;
        }

        private int f(char[] s, char x, char y) {
            int n = s.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> pos = new HashMap<>();
                pos.put(0, i - 1);
                int d = 0;
                for (; i < n && (s[i] == x || s[i] == y); i++) {
                    d += s[i] == x ? 1 : -1;
                    if (pos.containsKey(d)) {
                        ans = Math.max(ans, i - pos.get(d));
                    } else {
                        pos.put(d, i);
                    }
                }
            }
            return ans;
        }
    }

}
