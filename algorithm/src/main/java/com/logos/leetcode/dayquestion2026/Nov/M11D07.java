package com.logos.leetcode.dayquestion2026.Nov;

import java.util.PriorityQueue;

/**
 * @Package com.logos.leetcode.dayquestion2026.Nov
 * @author logos
 * date 2026/11/7 10:25
 * @version v1.0
 */
public class M11D07 {

    /**
     * 1882. 使用服务器处理任务
     * <a href="https://leetcode.cn/problems/process-tasks-using-servers/description/"/>
     */

    class Solution {
        public int[] assignTasks(int[] servers, int[] tasks) {
            PriorityQueue<int[]> idle = new PriorityQueue<>((a, b) ->
                    a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
            );
            for (int i = 0; i < servers.length; i++) {
                idle.offer(new int[]{servers[i], i});
            }

            PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
            long now = 0;

            for (int i = 0; i < tasks.length; i++) {
                now = Math.max(now, i);
                release(busy, idle, servers, now);
                if (idle.isEmpty()) {
                    now = busy.peek()[0];
                    release(busy, idle, servers, now);
                }
                int[] p = idle.poll();
                busy.offer(new long[]{now + tasks[i], p[1]});
                tasks[i] = p[1];
            }
            return tasks;
        }

        private void release(PriorityQueue<long[]> busy, PriorityQueue<int[]> idle, int[] servers, long now) {
            while (!busy.isEmpty() && busy.peek()[0] <= now) {
                int i = (int) busy.poll()[1];
                idle.offer(new int[]{servers[i], i});
            }
        }
    }

}
