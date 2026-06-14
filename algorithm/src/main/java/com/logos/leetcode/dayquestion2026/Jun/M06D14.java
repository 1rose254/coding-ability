package com.logos.leetcode.dayquestion2026.Jun;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/6/14 8:59
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D14 {

    /**
     * 2130. 链表最大孪生和
     * <a href="https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/description/"/>
     */
    class Solution {
        public int pairSum(ListNode head) {
            ListNode mid = middleNode(head);
            ListNode head2 = reverseList(mid);

            int ans = 0;
            while (head2 != null) {
                ans = Math.max(ans, head.val + head2.val);
                head = head.next;
                head2 = head2.next;
            }
            return ans;
        }

        private ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            return pre;
        }
    }

}
