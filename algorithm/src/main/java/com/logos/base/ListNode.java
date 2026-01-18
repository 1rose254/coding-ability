package com.logos.base;

/**
 * @author logos
 * date 2026/1/18 21:32
 * @version v1.0
 * @Package com.logos.base
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
