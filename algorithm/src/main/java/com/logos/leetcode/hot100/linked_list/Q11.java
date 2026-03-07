package com.logos.leetcode.hot100.linked_list;

import com.logos.base.Node;

/**
 * @author logos
 * date 2026/3/7 19:34
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q11 {

    /**
     * 138. 随机链表的复制
     */

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node cur = head;
            Node next = null;
            Node node = null;
            while (cur != null) {
                node = new Node(cur.val);
                next = cur.next;
                node.next = next;
                cur.next = node;
                cur = next;
            }
            cur = head;
            node = cur.next;
            while (cur != null && node != null) {
                node.random = cur.random == null ? null : cur.random.next;
                cur = node.next;
                if (cur == null) {
                    break;
                }
                node = cur.next;
            }
            Node ans = head.next;
            cur = head;
            while (cur != null && cur.next != null) {
                next = cur.next.next;
                node = cur.next;
                cur.next = next;
                node.next = next != null ? next.next : null;
                cur = next;
            }
            return ans;
        }
    }

}
