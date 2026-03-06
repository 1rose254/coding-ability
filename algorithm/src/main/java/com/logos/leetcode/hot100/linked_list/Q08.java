package com.logos.leetcode.hot100.linked_list;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/3/6 10:17
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q08 {

    /**
     * 19. 删除链表的倒数第 N 个结点
     */

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyHead = new ListNode(0, head);
            ListNode left = dummyHead;
            ListNode right = dummyHead;
            while (n-- >= 0) {
                right = right.next;
            }
            while (right != null) {
                right = right.next;
                left = left.next;
            }
            left.next = left.next.next;
            return dummyHead.next;
        }
    }

}
