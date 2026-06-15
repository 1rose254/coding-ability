package com.logos.leetcode.dayquestion2026.Jun;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/6/15 20:14
 * @version v1.0
 * @Package com.logos.leetcode.dayquestion2026.Jun
 */
public class M06D15 {

    /**
     * 2095. 删除链表的中间节点
     * <a href="https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/description/"/>
     */

    class Solution {
        public ListNode deleteMiddle(ListNode head) {
            ListNode slowNode = head;
            ListNode fastNode = head;
            ListNode delPreNode = null;
            while (fastNode != null && fastNode.next != null) {
                delPreNode = slowNode;
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
            }
            if (delPreNode == null) {
                return null;
            }
            delPreNode.next = delPreNode.next.next;
            return head;
        }
    }

}
