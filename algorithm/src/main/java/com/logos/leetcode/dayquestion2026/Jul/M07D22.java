package com.logos.leetcode.dayquestion2026.Jul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author logos
 * date 2026/7/21 19:46
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jul
 */
public class M07D22 {
    /**
     * 3501. 操作后最大活跃区段数 II
     * <a href="https://leetcode.cn/problems/maximize-active-section-with-trade-ii/description/"/>
     */

    class Solution {
        private record Pair(int l, int r) {
        }

        private static class SparseTable {
            private final int[][] st;

            SparseTable(List<Pair> a) {
                int n = a.size() - 1;
                int w = 32 - Integer.numberOfLeadingZeros(n);
                st = new int[w][n];
                for (int j = 0; j < n; j++) {
                    st[0][j] = a.get(j).r - a.get(j).l + a.get(j + 1).r - a.get(j + 1).l;
                }
                for (int i = 1; i < w; i++) {
                    for (int j = 0; j + (1 << i) <= n; j++) {
                        st[i][j] = Math.max(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
                    }
                }
            }

            int query(int l, int r) {
                if (l >= r) {
                    return 0;
                }
                int k = 32 - Integer.numberOfLeadingZeros(r - l) - 1;
                return Math.max(st[k][l], st[k][r - (1 << k)]);
            }
        }

        public List<Integer> maxActiveSectionsAfterTrade(String S, int[][] queries) {
            char[] s = S.toCharArray();
            int n = s.length;
            int total1 = 0;
            List<Pair> a = new ArrayList<>();
            a.add(new Pair(-1, -1));
            int start = 0;
            for (int i = 0; i < n; i++) {
                if (i == n - 1 || s[i] != s[i + 1]) {
                    if (s[i] == '1') {
                        total1 += i - start + 1;
                    } else {
                        a.add(new Pair(start, i + 1));
                    }
                    start = i + 1;
                }
            }
            a.add(new Pair(n + 1, n + 1));

            SparseTable st = new SparseTable(a);
            List<Integer> ans = new ArrayList<>(queries.length);
            for (int[] query : queries) {
                int ql = query[0];
                int qr = query[1] + 1;

                int i = Collections.binarySearch(a, new Pair(ql, 0), (p, q) -> p.l - q.l);
                if (i < 0) i = ~i;
                int j = Collections.binarySearch(a, new Pair(0, qr + 1), (p, q) -> p.r - q.r);
                if (j < 0) j = ~j;
                j--;

                int mx = 0;
                if (i <= j) {
                    int full = st.query(i, j);
                    int sl = merge(a.get(i - 1).r - ql, a.get(i).r - a.get(i).l);
                    int sr = merge(qr - a.get(j + 1).l, a.get(j).r - a.get(j).l);
                    mx = Math.max(full, Math.max(sl, sr));
                } else if (i == j + 1) {
                    mx = merge(a.get(i - 1).r - ql, qr - a.get(j + 1).l);
                }
                ans.add(total1 + mx);
            }
            return ans;
        }

        private int merge(int x, int y) {
            return x > 0 && y > 0 ? x + y : 0;
        }
    }

}
