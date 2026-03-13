package com.logos.leetcode.dayquestion2026.Mar;

import java.util.PriorityQueue;

/**
 * @author logos
 * date 2026/3/13 8:04
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Mar
 */
public class M04D13 {

    /**
     * 3296. 移山所需的最少秒数
     * <a href="https://leetcode.cn/problems/minimum-number-of-seconds-to-make-mountain-height-zero/description/"/>
     */

    class Solution {
        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
            long seconds = 0;
            PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a, b) -> Long.compare(a[0] + a[1], b[0] + b[1]));
            for (int workerTime : workerTimes) {
                pq.offer(new long[] { 0, workerTime, workerTime });
            }
            for (int i = 1; i <= mountainHeight; i++) {
                long[] arr = pq.poll();
                long totalTime = arr[0], nextTime = arr[1], originalTime = arr[2];
                seconds = totalTime + nextTime;
                pq.offer(new long[] { totalTime + nextTime, nextTime + originalTime, originalTime });
            }
            return seconds;
        }
    }

}
