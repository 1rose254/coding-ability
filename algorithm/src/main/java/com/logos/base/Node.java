package com.logos.base;

/**
 * @author logos
 * date 2026/3/6 14:33
 * @version v1.0
 * @Package com.logos.base
 */
public class Node {

    public int val;

    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}
