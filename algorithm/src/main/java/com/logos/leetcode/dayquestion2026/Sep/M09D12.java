package com.logos.leetcode.dayquestion2026.Sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author logos
 * date 2026/9/12 11:10
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Sep
 */
public class M09D12 {

    /**
     * 3414. 不重叠区间的最大得分
     * <a href="https://leetcode.cn/problems/maximum-score-of-non-overlapping-intervals/description/"/>
     */

    class Solution {
        private record Tuple(int l, int r, int weight, int i) {
        }

        private record Pair(long sum, List<Integer> id) {
        }

        public int[] maximumWeight(List<List<Integer>> intervals) {
            int n = intervals.size();
            Tuple[] a = new Tuple[n];
            for (int i = 0; i < n; i++) {
                List<Integer> interval = intervals.get(i);
                a[i] = new Tuple(interval.get(0), interval.get(1), interval.get(2), i);
            }
            Arrays.sort(a, (p, q) -> p.r - q.r);

            Pair[][] f = new Pair[n + 1][5];
            Arrays.setAll(f[0], i -> new Pair(0, new ArrayList<>()));
            for (int i = 0; i < n; i++) {
                Tuple t = a[i];
                int k = search(a, i, t.l);
                f[i + 1][0] = new Pair(0, new ArrayList<>());
                for (int j = 1; j < 5; j++) {
                    long s1 = f[i][j].sum;
                    long s2 = f[k + 1][j - 1].sum + t.weight;
                    if (s1 > s2) {
                        f[i + 1][j] = f[i][j];
                        continue;
                    }
                    List<Integer> newId = new ArrayList<>(f[k + 1][j - 1].id);
                    newId.add(t.i);
                    Collections.sort(newId);
                    if (s1 == s2 && compareLists(f[i][j].id, newId) < 0) {
                        newId = f[i][j].id;
                    }
                    f[i + 1][j] = new Pair(s2, newId);
                }
            }
            return f[n][4].id.stream().mapToInt(v -> v).toArray();
        }

        private int search(Tuple[] a, int right, int upper) {
            int left = -1;
            while (left + 1 < right) {
                int mid = (left + right) >>> 1;
                if (a[mid].r < upper) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        private int compareLists(List<Integer> a, List<Integer> b) {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return a.size() - b.size();
        }
    }

}
