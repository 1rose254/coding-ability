package com.logos.leetcode.hot100.linked_list;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/3/5 21:49
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q02 {

    /**
     * 206. 反转链表
     */

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        public ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

}
