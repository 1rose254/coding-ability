package com.logos.leetcode.hot100.linked_list;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/3/5 21:50
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q03 {

    /**
     * 234. 回文链表
     */

    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head.next == null) {
                return true;
            }
            if (head.next.next == null) {
                return head.val == head.next.val;
            }
            ListNode mid = findMid(head);
            ListNode lastHead = reverse(mid);
            ListNode headA = head;
            ListNode headB = lastHead;
            while (headB != null) {
                if (headA.val != headB.val) {
                    return false;
                }
                headA = headA.next;
                headB = headB.next;
            }
            reverse(lastHead);
            return true;
        }

        private ListNode findMid(ListNode head) {
            ListNode fast = head.next.next;
            ListNode slow = head.next;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        private ListNode reverse(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

}
