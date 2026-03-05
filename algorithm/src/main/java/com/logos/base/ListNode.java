package com.logos.base;

/**
 * @author logos
 * date 2026/1/18 21:32
 * @version v1.0
 * @Package com.logos.base
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
