package com.logos.leetcode.hot100.linked_list;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/3/5 21:53
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q04 {

    /**
     * 141. 环形链表
     */

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode fast = head.next.next;
            ListNode slow = head.next;
            while (fast != slow) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return true;
        }
    }

}
