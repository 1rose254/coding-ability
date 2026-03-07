package com.logos.leetcode.hot100.linked_list;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/3/7 19:41
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q12 {

    /**
     * 148. 排序链表
     */

    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode head2 = midNode(head);
            head = sortList(head);
            head2 = sortList(head2);
            return mergeList(head, head2);
        }

        private ListNode midNode(ListNode head) {
            ListNode pre = null;
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            pre.next = null;
            return slow;
        }

        private ListNode mergeList(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode();
            ListNode cur = dummyHead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 == null ? l2 : l1;
            return dummyHead.next;
        }

        public static ListNode start, end;

        public static void merge(ListNode l1, ListNode r1, ListNode l2, ListNode r2) {
            ListNode pre;
            if (l1.val <= l2.val) {
                pre = l1;
                start = l1;
                l1 = l1.next;
            } else {
                pre = l2;
                start = l2;
                l2 = l2.next;
            }
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    pre.next = l1;
                    pre = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    pre = l2;
                    l2 = l2.next;
                }
            }
            if (l1 != null) {
                pre.next = l1;
                end = r1;
            } else {
                pre.next = l2;
                end = r2;
            }
        }

        public static ListNode findNode(ListNode start, int k) {
            while (start.next != null && --k > 0) {
                start = start.next;
            }
            return start;
        }

        public ListNode sortList2(ListNode head) {
            int n = 0;
            ListNode cur = head;
            while (cur != null) {
                n++;
                cur = cur.next;
            }
            ListNode l1, r1, l2, r2, next, lastEnd;
            for (int step = 1; step < n; step <<= 1) {
                l1 = head;
                r1 = findNode(l1, step);
                l2 = r1.next;
                r2 = findNode(l2, step);
                next = r2.next;
                r1.next = null;
                r2.next = null;
                merge(l1, r1, l2, r2);
                head = start;
                lastEnd = end;
                while (next != null) {
                    l1 = next;
                    r1 = findNode(l1, step);
                    l2 = r1.next;
                    if (l2 == null) {
                        lastEnd.next = l1;
                        break;
                    }
                    r2 = findNode(l2, step);
                    next = r2.next;
                    r1.next = null;
                    r2.next = null;
                    merge(l1, r1, l2, r2);
                    lastEnd.next = start;
                    lastEnd = end;
                }
            }
            return head;
        }
    }

}
