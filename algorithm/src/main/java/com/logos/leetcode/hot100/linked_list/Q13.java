package com.logos.leetcode.hot100.linked_list;

import com.logos.base.ListNode;

import java.util.PriorityQueue;

/**
 * @author logos
 * date 2026/3/7 19:50
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q13 {

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int k = lists.length;
            PriorityQueue<ListNode> heap = new PriorityQueue<>((x, y) -> x.val - y.val);
            for (int i = 0; i < k; i++) {
                if (lists[i] != null) {
                    heap.add(lists[i]);
                    lists[i] = lists[i].next;
                }
            }
            if (heap.isEmpty()) {
                return null;
            }
            ListNode dummyHead = new ListNode();
            ListNode cur = dummyHead;
            while (!heap.isEmpty()) {
                ListNode tmp = heap.poll();
                cur.next = tmp;
                cur = cur.next;
                if (tmp.next != null) {
                    heap.add(tmp.next);
                }
            }
            return dummyHead.next;
        }

        public ListNode mergeKLists2(ListNode[] lists) {
            return mergeKLists(lists, 0, lists.length - 1);
        }

        private ListNode mergeKLists(ListNode[] lists, int l, int r) {
            if (l > r) {
                return null;
            }
            if (l == r) {
                return lists[l];
            }
            int mid = l + (r - l) / 2;
            ListNode l1 = mergeKLists(lists, l, mid);
            ListNode l2 = mergeKLists(lists, mid + 1, r);
            return mergeTwoList(l1, l2);
        }

        private ListNode mergeTwoList(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode();
            ListNode cur = dummyHead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 == null ? l2 : l1;
            return dummyHead.next;
        }
    }

}
