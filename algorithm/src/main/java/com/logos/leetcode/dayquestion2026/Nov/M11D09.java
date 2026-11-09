package com.logos.leetcode.dayquestion2026.Nov;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/9 10:57
 * @version v1.0
 */
public class M11D09 {

    /**
     * 1606. 找到处理最多请求的服务器
     * <a href="https://leetcode.cn/problems/find-servers-that-handled-most-number-of-requests/description/"/>
     */

    class Solution {
        public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
            int n = arrival.length;
            if (k >= n) {
                List<Integer> ans = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
            PriorityQueue<Integer> idle = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                idle.offer(i);
            }

            PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            int[] cnt = new int[k];
            int maxCnt = 0;
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                    int j = busy.poll()[1];
                    int virtual = i + (j - i % k + k) % k;
                    idle.offer(virtual);
                }
                if (idle.isEmpty()) {
                    continue;
                }
                int j = idle.poll() % k;
                busy.offer(new int[]{arrival[i] + load[i], j});
                cnt[j]++;
                if (cnt[j] > maxCnt) {
                    maxCnt = cnt[j];
                    ans.clear();
                    ans.add(j);
                } else if (cnt[j] == maxCnt) {
                    ans.add(j);
                }
            }
            return ans;
        }
    }

}
