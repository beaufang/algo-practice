package com.beau.leetcode;

import com.beau.common.ListNode;

// 21
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(); // 哨兵
        ListNode tail = sentinel;
        ListNode i = l1, j = l2;
        while (i != null || j != null) {
            if (i != null && (j == null ||  i.val <= j.val)) {
                tail.next = i;
                tail = i;
                i = i.next;
            } else {
                tail.next = j;
                tail = tail.next;
                j = j.next;
            }
        }
        return sentinel.next;
    }
}
