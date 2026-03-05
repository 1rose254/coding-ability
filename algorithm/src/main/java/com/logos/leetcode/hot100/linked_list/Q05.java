package com.logos.leetcode.hot100.linked_list;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/3/5 21:55
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q05 {

    /**
     * 142. 环形链表 II
     */

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode fast = head.next.next;
            ListNode slow = head.next;
            while (fast != slow) {
                if (fast == null || fast.next == null) {
                    return null;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }

}
