package com.logos.leetcode.hot100.linked_list;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/3/5 21:38
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q01 {

    /**
     * 160. 相交链表
     */

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode cur = headA;
            int diff = 0;
            while (cur != null) {
                diff++;
                cur = cur.next;
            }
            cur = headB;
            while (cur != null) {
                diff--;
                cur = cur.next;
            }
            if (diff < 0) {
                ListNode tmp = headA;
                headA = headB;
                headB = tmp;
                diff = -diff;
            }
            ListNode a = headA;
            ListNode b = headB;
            while (diff-- > 0) {
                a = a.next;
            }
            while (a != b) {
                a = a.next;
                b = b.next;
            }
            return a;
        }
    }

}
