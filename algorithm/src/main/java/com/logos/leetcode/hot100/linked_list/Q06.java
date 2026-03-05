package com.logos.leetcode.hot100.linked_list;

import com.logos.base.ListNode;

/**
 * @author logos
 * date 2026/3/5 21:59
 * @version v1.0
 * @Package com.logos.leetcode.hot100.linked_list
 */
public class Q06 {

    /**
     * 21. 合并两个有序链表
     */

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }
            if (list1 == null || list2 == null) {
                return list1 == null ? list2 : list1;
            }
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }

}
