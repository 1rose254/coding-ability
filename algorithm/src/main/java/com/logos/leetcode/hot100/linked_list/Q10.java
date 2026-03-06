package com.logos.leetcode.hot100.linked_list;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/3/6 14:23
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q10 {

    /**
     * 25. K 个一组翻转链表
     */

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode start = head;
            ListNode end = boolReverse(start, k);
            if (end == null) {
                return head;
            }
            head = end;
            reverse(start, end);
            ListNode lastEnd = start;
            while (lastEnd.next != null) {
                start = lastEnd.next;
                end = boolReverse(start, k);
                if (end == null) {
                    return head;
                }
                reverse(start, end);
                lastEnd.next = end;
                lastEnd = start;
            }
            return head;
        }

        private void reverse(ListNode start, ListNode end) {
            ListNode cur = start;
            ListNode pre = null;
            ListNode next = null;
            end = end.next;
            while (cur != end) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            start.next = end;
        }

        private ListNode boolReverse(ListNode start, int k) {
            while (start != null && --k > 0) {
                start = start.next;
            }
            return start;
        }
    }

}
