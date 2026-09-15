package com.logos.leetcode.dayquestion2026.Sep;

/**
 * @Package com.logos.leetcode.dayquestion2026.Sep
 * @author logos
 * date 2026/9/15 10:07
 * @version v1.0
 */
public class M09D15 {

    /**
     * 2472. 不重叠回文子字符串的最大数目
     * <a href="https://leetcode.cn/problems/maximum-number-of-non-overlapping-palindrome-substrings/description/"/>
     */

    class Solution {
        public static int maxPalindromes(String str, int k) {
            manacherss(str.toCharArray());
            int ans = 0;
            int next = 0;
            while ((next = find(next, k)) != -1) {
                ans++;
            }
            return ans;
        }

        public static int MAXN = 2001;

        public static char[] ss = new char[MAXN << 1];

        public static int[] p = new int[MAXN << 1];

        public static int n;

        public static void manacherss(char[] a) {
            n = a.length * 2 + 1;
            for (int i = 0, j = 0; i < n; i++) {
                ss[i] = (i & 1) == 0 ? '#' : a[j++];
            }
        }

        public static int find(int l, int k) {
            for (int i = l, c = l, r = l, len; i < n; i++) {
                len = r > i ? Math.min(p[2 * c - i], r - i) : 1;
                while (i + len < n && i - len >= l && ss[i + len] == ss[i - len]) {
                    if (++len > k) {
                        return i + k + (ss[i + k] != '#' ? 1 : 0);
                    }
                }
                if (i + len > r) {
                    r = i + len;
                    c = i;
                }
                p[i] = len;
            }
            return -1;
        }
    }

}
