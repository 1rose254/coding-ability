package com.logos.leetcode.hot100.heap;

import java.util.PriorityQueue;

/**
 * @author logos
 * date 2026/3/9 17:03
 * @version v1.0
 * @Package com.logos.leetcode.hot100.heap
 */
public class Q03 {

    /**
     * 295. 数据流的中位数
     */

    class MedianFinder {
        private static PriorityQueue<Integer> maxQue = new PriorityQueue<>((x, y) -> y - x);

        private static PriorityQueue<Integer> minQue = new PriorityQueue<>();

        public MedianFinder() {
            maxQue.clear();
            minQue.clear();
        }

        private void balance() {
            if (Math.abs(minQue.size() - maxQue.size()) == 2) {
                if (maxQue.size() > minQue.size()) {
                    minQue.add(maxQue.poll());
                } else {
                    maxQue.add(minQue.poll());
                }
            }
        }

        public void addNum(int num) {
            if (maxQue.isEmpty() || num <= maxQue.peek()) {
                maxQue.add(num);
            } else {
                minQue.add(num);
            }
            balance();
        }

        public double findMedian() {
            if (maxQue.size() == minQue.size()) {
                return (minQue.peek() + maxQue.peek()) / 2.0;
            } else {
                if (maxQue.size() > minQue.size()) {
                    return maxQue.peek();
                } else {
                    return minQue.peek();
                }
            }
        }
    }

}
