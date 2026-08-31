package com.logos.leetcode.dayquestion2026.Aug;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/8/31 10:48
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Aug
 */
public class M08D31 {

    /**
     * 2058. 找出临界点之间的最小和最大距离
     * <a href="https://leetcode.cn/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/"/>
     */

    class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            int first = 0;
            int pre = Integer.MIN_VALUE / 2;
            int minDis = Integer.MAX_VALUE;
            ListNode a = head;
            ListNode b = head.next;
            ListNode c = head.next.next;
            for (int i = 1; c != null; i++) {
                if (a.val < b.val && b.val > c.val || a.val > b.val && b.val < c.val) {
                    if (first == 0) {
                        first = i;
                    }
                    minDis = Math.min(minDis, i - pre);
                    pre = i;
                }
                a = b;
                b = c;
                c = c.next;
            }
            if (first >= pre) {
                return new int[]{-1, -1};
            }
            return new int[]{minDis, pre - first};
        }
    }

}
