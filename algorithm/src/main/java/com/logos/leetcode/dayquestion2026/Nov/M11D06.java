package com.logos.leetcode.dayquestion2026.Nov;

import java.util.Arrays;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/6 11:04
 * @version v1.0
 */
public class M11D06 {


    /**
     * 2747. 统计没有收到请求的服务器数目
     * <a href="https://leetcode.cn/problems/count-zero-request-servers/description/"/>
     */

    class Solution {
        public int[] countServers(int n, int[][] logs, int x, int[] queries) {
            Arrays.sort(logs, (a, b) -> a[1] - b[1]);
            Integer[] idx = new Integer[queries.length];
            Arrays.setAll(idx, i -> i);
            Arrays.sort(idx, (i, j) -> queries[i] - queries[j]);
            int[] cnt = new int[n + 1];
            int notReceives = n;
            int left = 0;
            int right = 0;
            for (int qid : idx) {
                int q = queries[qid];
                while (right < logs.length && logs[right][1] <= q) {
                    int i = logs[right][0];
                    if (cnt[i] == 0) {
                        notReceives--;
                    }
                    cnt[i]++;
                    right++;
                }
                while (left < logs.length && logs[left][1] < q - x) {
                    int i = logs[left][0];
                    cnt[i]--;
                    if (cnt[i] == 0) {
                        notReceives++;
                    }
                    left++;
                }
                queries[qid] = notReceives;
            }
            return queries;
        }
    }

}
