package com.logos.leetcode.hot100.linked_list;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/3/6 10:10
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q07 {

    /**
     * 2. 两数相加
     */

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode cur = head;
            int sum = 0;
            int val = 0;
            for (ListNode headA = l1, headB = l2; headA != null || headB != null; headA = headA == null ? headA
                    : headA.next, headB = headB == null ? headB : headB.next) {
                sum = val + (headA == null ? 0 : headA.val) + (headB == null ? 0 : headB.val);
                val = sum / 10;
                sum %= 10;
                ListNode tmp = new ListNode(sum);
                cur.next = tmp;
                cur = tmp;
            }
            if (val != 0) {
                cur.next = new ListNode(val);
            }
            return head.next;
        }
    }

}
