package com.logos.leetcode.dayquestion2026.May;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/5/5 10:59
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.May
 */
public class M05D05 {

    /**
     * 61. 旋转链表
     * <a href="https://leetcode.cn/problems/rotate-list/description/"/>
     */

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0){
                return head;
            }
            int size = 0;
            ListNode cur = head;
            while (cur != null) {
                cur = cur.next;
                size++;
            }
            k %= size;
            if (k == 0) {
                return head;
            }
            ListNode result = reverseList(head);
            cur = result;
            while (--k > 0) {
                cur = cur.next;
            }
            ListNode cur2 = cur.next;
            cur.next = null;
            ListNode ret1 = reverseList(result);
            ListNode ret2 = reverseList(cur2);
            result = ret1;
            while (ret1.next != null) {
                ret1 = ret1.next;
            }
            ret1.next = ret2;
            return result;
        }

        private ListNode reverseList(ListNode head1) {
            ListNode cur = head1;
            ListNode pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

}
