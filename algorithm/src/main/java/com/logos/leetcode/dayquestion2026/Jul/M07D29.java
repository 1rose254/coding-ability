package com.logos.leetcode.dayquestion2026.Jul;

/**
 * @author logos
 * date 2026/7/28 23:08
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D29 {

    /**
     * 3518. 最小回文排列 II
     * <a href="https://leetcode.cn/problems/smallest-palindromic-rearrangement-ii/description/"/>
     */

    class Solution {
        public String smallestPalindrome(String s, int k) {
            int n = s.length();
            int m = n / 2;

            int[] cnt = new int[26];
            for (int i = 0; i < m; i++) {
                cnt[s.charAt(i) - 'a']++;
            }

            if (perm(m, cnt, k) < k) {
                return "";
            }

            char[] leftS = new char[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 26; j++) {
                    if (cnt[j] == 0) {
                        continue;
                    }
                    cnt[j]--;
                    int p = perm(m - i - 1, cnt, k);
                    if (p >= k) {
                        leftS[i] = (char) ('a' + j);
                        break;
                    }
                    k -= p;
                    cnt[j]++;
                }
            }

            StringBuilder ans = new StringBuilder(n);
            ans.append(leftS);
            if (n % 2 > 0) {
                ans.append(s.charAt(n / 2));
            }
            for (int i = m - 1; i >= 0; i--) {
                ans.append(leftS[i]);
            }
            return ans.toString();
        }

        private int comb(int n, int m, int k) {
            m = Math.min(m, n - m);
            long res = 1;
            for (int i = 1; i <= m; i++) {
                res = res * (n + 1 - i) / i;
                if (res >= k) {
                    return k;
                }
            }
            return (int) res;
        }

        private int perm(int sz, int[] cnt, int k) {
            long res = 1;
            for (int c : cnt) {
                if (c == 0) {
                    continue;
                }
                res *= comb(sz, c, k);
                if (res >= k) {
                    return k;
                }
                sz -= c;
            }
            return (int) res;
        }
    }

}
