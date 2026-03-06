package com.logos.leetcode.hot100.linked_list;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/3/6 10:22
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q09 {

    /**
     * 24. 两两交换链表中的节点
     */

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode a = head;
            ListNode b = head.next;
            ListNode c = head.next.next;
            a.next = swapPairs(c);
            b.next = a;
            return b;
        }

        public ListNode swapPairs2(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode node0 = dummy;
            ListNode a = head;
            while (a != null && a.next != null) {
                ListNode b = a.next;
                ListNode c = b.next;

                node0.next = b;
                b.next = a;
                a.next = c;

                node0 = a;
                a = c;
            }
            return dummy.next;
        }
    }

}
